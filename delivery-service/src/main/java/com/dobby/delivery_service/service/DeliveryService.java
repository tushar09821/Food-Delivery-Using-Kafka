package com.dobby.delivery_service.service;

import com.dobby.delivery_service.dao.DeliveryDao;
import com.dobby.delivery_service.dao.DeliveryPartnerDao;
import com.dobby.delivery_service.dto.DeliveryAssignDto;
import com.dobby.delivery_service.dto.DeliveryRequestDto;
import com.dobby.delivery_service.dto.DeliveryResponseDto;
import com.dobby.delivery_service.dto.DeliveryStatusDto;
import com.dobby.delivery_service.entity.Delivery;
import com.dobby.delivery_service.entity.DeliveryPartner;
import com.dobby.delivery_service.exception.ResourceNotFoundException;
import com.dobby.delivery_service.mapper.DeliveryMapper;
import com.dobby.delivery_service.util.DeliveryStatus;
import com.dobby.delivery_service.util.PartnerAvailabliltyStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryDao deliveryDao;

    @Autowired
    private DeliveryPartnerDao deliveryPartnerDao;

    @Autowired
    private DeliveryMapper _mapper;

    public List<DeliveryResponseDto> getAllDeliveries(){
        return _mapper.toListDto(deliveryDao.findAll());
    }

    public List<DeliveryResponseDto> getAllPendingDeliveries(){
        return _mapper.toListDto(deliveryDao.getAllPendingDeliveries(DeliveryStatus.CREATED));
    }

    public Delivery getById(int id){
        return deliveryDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Delivery Not Found"));
    }

    public DeliveryResponseDto createDelivery(DeliveryRequestDto dto){
        dto.setStatus(DeliveryStatus.CREATED);
        Delivery d = _mapper.toEntity(dto);
        return _mapper.toResponseDto(deliveryDao.save(d));
    }
    public DeliveryResponseDto updateStatus(int delId, DeliveryStatusDto statusDto){
        Delivery delivery = getById(delId);
        if(delivery.getStatus()==DeliveryStatus.DELIVERED){
            throw  new IllegalStateException("Delivery already completed. Cannot update end time");
        }
        delivery.setStatus(statusDto.getStatus());
        if(statusDto.getStatus()==DeliveryStatus.DELIVERED){
            delivery.setEndTime(LocalDateTime.now());
        }
       return  _mapper.toResponseDto(deliveryDao.save(delivery));
    }

    public DeliveryResponseDto acceptDelivery(DeliveryAssignDto dto) {
        Delivery d = getById(dto.getDeliveryId());
        DeliveryPartner deliveryPartner = deliveryPartnerDao.findById(dto.getDeliveryPartnerId()).orElseThrow(()-> new ResourceNotFoundException("Delivery Partner Doesn't exists"));
        if(d.getStatus()!=DeliveryStatus.CREATED){
            throw new IllegalStateException("Delivery already assigned or invalid");
        }
        d.setDeliveryPartner(deliveryPartner);
        d.setStatus(DeliveryStatus.ASSIGNED);
        d =deliveryDao.save(d);
        deliveryPartner.setAvailabilityStatus(PartnerAvailabliltyStatus.ON_DELIVERY);

        return _mapper.toResponseDto(d);
    }
}
