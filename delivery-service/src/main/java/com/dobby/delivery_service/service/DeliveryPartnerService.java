package com.dobby.delivery_service.service;

import com.dobby.delivery_service.dao.DeliveryPartnerDao;
import com.dobby.delivery_service.dto.DeliveryPartnerRequestDto;
import com.dobby.delivery_service.dto.DeliveryPartnerResponseDto;
import com.dobby.delivery_service.dto.DeliveryPartnerStatusUpdateRequestDto;
import com.dobby.delivery_service.dto.DeliveryResponseDto;
import com.dobby.delivery_service.entity.DeliveryPartner;
import com.dobby.delivery_service.exception.ResourceNotFoundException;
import com.dobby.delivery_service.mapper.DeliveryPartnerMapper;
import com.dobby.delivery_service.util.PartnerAvailabliltyStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryPartnerService {
    @Autowired
    private DeliveryPartnerDao deliveryPartnerDao;
    @Autowired
    private DeliveryPartnerMapper mapper;

    public List<DeliveryPartnerResponseDto>getAllAvailableDeliveryPartners() {
        return mapper.toResponseList(deliveryPartnerDao.findAvailablePartners(PartnerAvailabliltyStatus.AVAILABLE));
    }

    public DeliveryPartnerResponseDto registerDeliveryPartner(DeliveryPartnerRequestDto dto) {
        DeliveryPartner partner = mapper.toEntity(dto);
        partner= deliveryPartnerDao.save(partner);
        return mapper.toResponseDto(partner);
    }

    private DeliveryPartner getByIdOrThrow(int id){
      return deliveryPartnerDao.findById(id).orElseThrow(()-> new ResourceNotFoundException("Delivery Partner Does not exist"));
    }
    public DeliveryPartnerResponseDto getById(int id){
        return mapper.toResponseDto(getByIdOrThrow(id));
    }

    public DeliveryPartnerStatusUpdateRequestDto updateStatus(int id, DeliveryPartnerStatusUpdateRequestDto status) {
        DeliveryPartner partner = getByIdOrThrow(id);
        partner.setAvailabilityStatus(status.getAvailabilityStatus());
        deliveryPartnerDao.save(partner);
        return status;
    }

    public DeliveryPartnerResponseDto updateDetails(int id, DeliveryPartnerRequestDto dto) {
        DeliveryPartner partner = getByIdOrThrow(id);
        mapper.updateEntityFromDto(dto,partner);
        deliveryPartnerDao.save(partner);
       return  mapper.toResponseDto(partner);

    }

}
