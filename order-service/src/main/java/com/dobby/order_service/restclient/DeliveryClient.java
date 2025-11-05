package com.dobby.order_service.restclient;

import com.dobby.order_service.dto.DeliveryRequestDto;
import com.dobby.order_service.util.ApiResponse;
import org.hibernate.annotations.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("DELIVERY-SERVICE")
@Component
public interface DeliveryClient {
    @PostMapping("/api/v1/delivery")
    public ResponseEntity<ApiResponse> createDelivery(@RequestBody DeliveryRequestDto dto);
}
