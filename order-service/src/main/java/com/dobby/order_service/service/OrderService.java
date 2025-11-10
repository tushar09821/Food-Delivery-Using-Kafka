package com.dobby.order_service.service;

import com.dobby.order_service.dao.OrderDao;
import com.dobby.order_service.dto.DeliveryRequestDto;
import com.dobby.order_service.dto.OrderRequestDto;
import com.dobby.order_service.dto.OrderResponseDto;
import com.dobby.order_service.dto.OrderStatusUpdate;
import com.dobby.order_service.entity.Order;
import com.dobby.order_service.exception.ResourceNotFoundException;
import com.dobby.order_service.kafka.KafkaProducer;
import com.dobby.order_service.mapper.OrderMapper;
import com.dobby.order_service.util.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderDao dao;

    @Autowired
    private OrderMapper mapper;

    @Autowired
    private KafkaProducer producer;

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
         OrderResponseDto response = mapper.toResponse(order);
         producer.sendOrderEvent(response);
         return response;
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
