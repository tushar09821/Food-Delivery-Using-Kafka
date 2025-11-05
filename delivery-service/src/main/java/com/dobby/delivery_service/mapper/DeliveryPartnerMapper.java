package com.dobby.delivery_service.mapper;

import com.dobby.delivery_service.dto.DeliveryPartnerRequestDto;
import com.dobby.delivery_service.dto.DeliveryPartnerResponseDto;
import com.dobby.delivery_service.dto.DeliveryResponseDto;
import com.dobby.delivery_service.entity.DeliveryPartner;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DeliveryPartnerMapper {

    DeliveryPartner toEntity(DeliveryPartnerRequestDto dto);

    DeliveryPartnerResponseDto toResponseDto(DeliveryPartner entity);

    List<DeliveryPartnerResponseDto> toResponseList(List<DeliveryPartner> list);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(DeliveryPartnerRequestDto dto, @MappingTarget DeliveryPartner entity);
}
