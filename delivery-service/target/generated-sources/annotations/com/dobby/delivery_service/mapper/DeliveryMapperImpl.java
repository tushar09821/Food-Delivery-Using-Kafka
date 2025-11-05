package com.dobby.delivery_service.mapper;

import com.dobby.delivery_service.dto.DeliveryRequestDto;
import com.dobby.delivery_service.dto.DeliveryResponseDto;
import com.dobby.delivery_service.entity.Delivery;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-08T21:29:59+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Amazon.com Inc.)"
)
@Component
public class DeliveryMapperImpl implements DeliveryMapper {

    @Override
    public Delivery toEntity(DeliveryRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Delivery delivery = new Delivery();

        delivery.setPickupAddress( dto.getPickupAddress() );
        delivery.setDropAddress( dto.getDropAddress() );
        delivery.setOrderId( dto.getOrderId() );
        delivery.setStatus( dto.getStatus() );

        return delivery;
    }

    @Override
    public DeliveryResponseDto toResponseDto(Delivery entity) {
        if ( entity == null ) {
            return null;
        }

        DeliveryResponseDto deliveryResponseDto = new DeliveryResponseDto();

        deliveryResponseDto.setId( entity.getId() );
        deliveryResponseDto.setOrderId( entity.getOrderId() );
        deliveryResponseDto.setDeliveryPartner( entity.getDeliveryPartner() );
        deliveryResponseDto.setStatus( entity.getStatus() );
        deliveryResponseDto.setPickupAddress( entity.getPickupAddress() );
        deliveryResponseDto.setDropAddress( entity.getDropAddress() );
        deliveryResponseDto.setEndTime( entity.getEndTime() );

        return deliveryResponseDto;
    }

    @Override
    public List<DeliveryResponseDto> toListDto(List<Delivery> list) {
        if ( list == null ) {
            return null;
        }

        List<DeliveryResponseDto> list1 = new ArrayList<DeliveryResponseDto>( list.size() );
        for ( Delivery delivery : list ) {
            list1.add( toResponseDto( delivery ) );
        }

        return list1;
    }

    @Override
    public void updateEntityFromDto(DeliveryRequestDto dto, Delivery entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getPickupAddress() != null ) {
            entity.setPickupAddress( dto.getPickupAddress() );
        }
        if ( dto.getDropAddress() != null ) {
            entity.setDropAddress( dto.getDropAddress() );
        }
        entity.setOrderId( dto.getOrderId() );
        if ( dto.getStatus() != null ) {
            entity.setStatus( dto.getStatus() );
        }
    }
}
