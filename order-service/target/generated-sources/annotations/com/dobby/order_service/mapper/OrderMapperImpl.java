package com.dobby.order_service.mapper;

import com.dobby.order_service.dto.OrderItemRequestDto;
import com.dobby.order_service.dto.OrderRequestDto;
import com.dobby.order_service.dto.OrderResponseDto;
import com.dobby.order_service.entity.Order;
import com.dobby.order_service.entity.OrderItem;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-08T18:45:33+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Amazon.com Inc.)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderResponseDto toResponse(Order entity) {
        if ( entity == null ) {
            return null;
        }

        OrderResponseDto orderResponseDto = new OrderResponseDto();

        orderResponseDto.setStatus( entity.getStatus() );
        orderResponseDto.setOrderId( entity.getOrderId() );
        orderResponseDto.setUserId( entity.getUserId() );
        orderResponseDto.setRestaurantId( entity.getRestaurantId() );
        orderResponseDto.setDeliveryAddress( entity.getDeliveryAddress() );
        orderResponseDto.setItems( orderItemListToOrderItemRequestDtoList( entity.getItems() ) );

        return orderResponseDto;
    }

    @Override
    public Order toEntity(OrderRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Order order = new Order();

        order.setUserId( dto.getUserId() );
        order.setRestaurantId( dto.getRestaurantId() );
        order.setDeliveryAddress( dto.getDeliveryAddress() );
        order.setItems( orderItemRequestDtoListToOrderItemList( dto.getItems() ) );
        order.setPickupAddress( dto.getPickupAddress() );

        return order;
    }

    @Override
    public List<OrderResponseDto> toResponseList(List<Order> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderResponseDto> list1 = new ArrayList<OrderResponseDto>( list.size() );
        for ( Order order : list ) {
            list1.add( toResponse( order ) );
        }

        return list1;
    }

    protected OrderItemRequestDto orderItemToOrderItemRequestDto(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }

        OrderItemRequestDto orderItemRequestDto = new OrderItemRequestDto();

        orderItemRequestDto.setMenuItemId( orderItem.getMenuItemId() );
        orderItemRequestDto.setQuantity( orderItem.getQuantity() );
        orderItemRequestDto.setPrice( orderItem.getPrice() );

        return orderItemRequestDto;
    }

    protected List<OrderItemRequestDto> orderItemListToOrderItemRequestDtoList(List<OrderItem> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderItemRequestDto> list1 = new ArrayList<OrderItemRequestDto>( list.size() );
        for ( OrderItem orderItem : list ) {
            list1.add( orderItemToOrderItemRequestDto( orderItem ) );
        }

        return list1;
    }

    protected OrderItem orderItemRequestDtoToOrderItem(OrderItemRequestDto orderItemRequestDto) {
        if ( orderItemRequestDto == null ) {
            return null;
        }

        OrderItem orderItem = new OrderItem();

        orderItem.setMenuItemId( orderItemRequestDto.getMenuItemId() );
        orderItem.setQuantity( orderItemRequestDto.getQuantity() );
        orderItem.setPrice( orderItemRequestDto.getPrice() );

        return orderItem;
    }

    protected List<OrderItem> orderItemRequestDtoListToOrderItemList(List<OrderItemRequestDto> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderItem> list1 = new ArrayList<OrderItem>( list.size() );
        for ( OrderItemRequestDto orderItemRequestDto : list ) {
            list1.add( orderItemRequestDtoToOrderItem( orderItemRequestDto ) );
        }

        return list1;
    }
}
