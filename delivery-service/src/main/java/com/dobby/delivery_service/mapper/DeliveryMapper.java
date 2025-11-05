package com.dobby.delivery_service.mapper;

import com.dobby.delivery_service.dto.DeliveryRequestDto;
import com.dobby.delivery_service.dto.DeliveryResponseDto;
import com.dobby.delivery_service.entity.Delivery;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import java.util.List;

@Mapper(componentModel = "spring")
public interface DeliveryMapper {

    Delivery toEntity(DeliveryRequestDto dto);

    DeliveryResponseDto toResponseDto(Delivery entity);

    List<DeliveryResponseDto> toListDto(List<Delivery> list);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(DeliveryRequestDto dto, @MappingTarget Delivery entity);
}
