package com.dobby.delivery_service.controller;

import com.dobby.delivery_service.dto.DeliveryAssignDto;
import com.dobby.delivery_service.dto.DeliveryRequestDto;
import com.dobby.delivery_service.dto.DeliveryResponseDto;
import com.dobby.delivery_service.service.DeliveryService;
import com.dobby.delivery_service.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/delivery")
public class DeliveryController {

    @Autowired
    private DeliveryService _service;

    @GetMapping()
    public ResponseEntity<ApiResponse> getAllDeliveriesTillNow(){
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success("All Deliveries",_service.getAllDeliveries()));
    }

    @PostMapping()
    public ResponseEntity<ApiResponse> createDelivery(@RequestBody DeliveryRequestDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Delivery Created",_service.createDelivery(dto)));
    }

    @GetMapping("/get-pending-deliveries")
    public ResponseEntity<ApiResponse> getPendingDeliveries(){
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success("All pending Deliveries",_service.getAllPendingDeliveries()));
    }
    @PatchMapping("/accept")
    public ResponseEntity<ApiResponse> acceptDelivery(@RequestBody DeliveryAssignDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success("Delivery Accepted",_service.acceptDelivery(dto)));
    }

}
