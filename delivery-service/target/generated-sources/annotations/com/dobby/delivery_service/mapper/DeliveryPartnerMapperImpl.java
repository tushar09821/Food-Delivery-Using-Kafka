package com.dobby.delivery_service.mapper;

import com.dobby.delivery_service.dto.DeliveryPartnerRequestDto;
import com.dobby.delivery_service.dto.DeliveryPartnerResponseDto;
import com.dobby.delivery_service.entity.Delivery;
import com.dobby.delivery_service.entity.DeliveryPartner;
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
public class DeliveryPartnerMapperImpl implements DeliveryPartnerMapper {

    @Override
    public DeliveryPartner toEntity(DeliveryPartnerRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        DeliveryPartner deliveryPartner = new DeliveryPartner();

        deliveryPartner.setName( dto.getName() );
        deliveryPartner.setPhoneNumber( dto.getPhoneNumber() );
        deliveryPartner.setEmail( dto.getEmail() );
        deliveryPartner.setAvailabilityStatus( dto.getAvailabilityStatus() );

        return deliveryPartner;
    }

    @Override
    public DeliveryPartnerResponseDto toResponseDto(DeliveryPartner entity) {
        if ( entity == null ) {
            return null;
        }

        DeliveryPartnerResponseDto deliveryPartnerResponseDto = new DeliveryPartnerResponseDto();

        deliveryPartnerResponseDto.setId( entity.getId() );
        deliveryPartnerResponseDto.setName( entity.getName() );
        deliveryPartnerResponseDto.setPhoneNumber( entity.getPhoneNumber() );
        deliveryPartnerResponseDto.setEmail( entity.getEmail() );
        deliveryPartnerResponseDto.setAvailabilityStatus( entity.getAvailabilityStatus() );
        List<Delivery> list = entity.getDeliveries();
        if ( list != null ) {
            deliveryPartnerResponseDto.setDeliveries( new ArrayList<Delivery>( list ) );
        }

        return deliveryPartnerResponseDto;
    }

    @Override
    public List<DeliveryPartnerResponseDto> toResponseList(List<DeliveryPartner> list) {
        if ( list == null ) {
            return null;
        }

        List<DeliveryPartnerResponseDto> list1 = new ArrayList<DeliveryPartnerResponseDto>( list.size() );
        for ( DeliveryPartner deliveryPartner : list ) {
            list1.add( toResponseDto( deliveryPartner ) );
        }

        return list1;
    }

    @Override
    public void updateEntityFromDto(DeliveryPartnerRequestDto dto, DeliveryPartner entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getName() != null ) {
            entity.setName( dto.getName() );
        }
        if ( dto.getPhoneNumber() != null ) {
            entity.setPhoneNumber( dto.getPhoneNumber() );
        }
        if ( dto.getEmail() != null ) {
            entity.setEmail( dto.getEmail() );
        }
        if ( dto.getAvailabilityStatus() != null ) {
            entity.setAvailabilityStatus( dto.getAvailabilityStatus() );
        }
    }
}
