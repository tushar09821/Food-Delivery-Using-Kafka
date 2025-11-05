package com.dobby.order_service.mapper;

import com.dobby.order_service.dto.OrderRequestDto;
import com.dobby.order_service.dto.OrderResponseDto;
import com.dobby.order_service.entity.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderResponseDto toResponse(Order entity);

    Order toEntity(OrderRequestDto dto);
    List<OrderResponseDto> toResponseList(List<Order> list);
}
