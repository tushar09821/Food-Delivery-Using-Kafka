package com.dobby.order_service.service;

import com.dobby.order_service.dao.OrderDao;
import com.dobby.order_service.dto.DeliveryRequestDto;
import com.dobby.order_service.dto.OrderRequestDto;
import com.dobby.order_service.dto.OrderResponseDto;
import com.dobby.order_service.dto.OrderStatusUpdate;
import com.dobby.order_service.entity.Order;
import com.dobby.order_service.exception.ResourceNotFoundException;
import com.dobby.order_service.mapper.OrderMapper;
import com.dobby.order_service.restclient.DeliveryClient;
import com.dobby.order_service.util.ApiResponse;
import com.dobby.order_service.util.CommonConstants;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;

import java.text.MessageFormat;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderDao dao;

    @Autowired
    private DeliveryClient deliveryClient;

    @Autowired
    private OrderMapper mapper;

    private Order getById(int id){
        return dao.findById(id).orElseThrow(()-> new ResourceNotFoundException(MessageFormat.format(CommonConstants.ORDER_NOT_FOUND,id)));
    }
    public OrderResponseDto getOrderById(int id){
        return mapper.toResponse(getById(id));
    }

    public OrderResponseDto createOrder(OrderRequestDto dto){
        Order order = mapper.toEntity(dto);
        order.setStatus(CommonConstants.ORDER_STATUS_PLACED);
         order = dao.save(order);
        try {
            DeliveryRequestDto deliveryDto = new DeliveryRequestDto(
                    order.getOrderId(),
                    order.getPickupAddress(),
                    order.getDeliveryAddress()
            );

            ResponseEntity<ApiResponse> response = deliveryClient.createDelivery(deliveryDto);

            if (response.getStatusCode().is2xxSuccessful()) {
                order.setStatus(CommonConstants.ORDER_STATUS_PLACED);
            } else {
                order.setStatus(CommonConstants.ORDER_STATUS_DELIVERY_PENDING);
            }

        } catch (Exception e) {
            order.setStatus(CommonConstants.ORDER_STATUS_DELIVERY_PENDING);
        }
        order = dao.save(order);
        return mapper.toResponse(order);
    }

    public OrderResponseDto updateOrderStatus(int id, OrderStatusUpdate status){
        Order order = getById(id);
        order.setStatus(status.getStatus());
        return mapper.toResponse(dao.save(order));
    }
    public List<OrderResponseDto> getOrdersByUserId(int id){
        return mapper.toResponseList(dao.findByUserId(id));
    }


    public OrderResponseDto delete(int orderId) {
          dao.deleteById(orderId);
          return new OrderResponseDto();
    }
}
