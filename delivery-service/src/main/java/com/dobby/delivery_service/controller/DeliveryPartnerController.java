package com.dobby.delivery_service.controller;

import com.dobby.delivery_service.dto.DeliveryPartnerRequestDto;
import com.dobby.delivery_service.dto.DeliveryPartnerStatusUpdateRequestDto;
import com.dobby.delivery_service.dto.DeliveryResponseDto;
import com.dobby.delivery_service.service.DeliveryPartnerService;
import com.dobby.delivery_service.service.DeliveryService;
import com.dobby.delivery_service.util.ApiResponse;
import jakarta.validation.Valid;
import org.apache.catalina.core.ApplicationPushBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/delivery-partners")
public class DeliveryPartnerController {
    @Autowired
    private DeliveryPartnerService _service;

    @Autowired
    private DeliveryService _delService;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getById(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Delivery partner",_service.getById(id)));
    }

    @GetMapping()
    public ResponseEntity<ApiResponse> getAllDeliveryPartners(){
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success("List of All available ", _service.getAllAvailableDeliveryPartners()));
    }

    @PostMapping()
    public ResponseEntity<ApiResponse> registerDeliveryPartner(@Valid @RequestBody DeliveryPartnerRequestDto dto){
        return  ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Registration of Delivery Pattern ", _service.registerDeliveryPartner(dto)));
    }
    @PatchMapping("/{id}/status")
    public ResponseEntity<ApiResponse> updateDeliveryPartnerStatus(@PathVariable int id, @RequestBody DeliveryPartnerStatusUpdateRequestDto status){
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success("Update delivery partner details ", _service.updateStatus(id,status)));
    }
    @PatchMapping("/{id}/update")
    public ResponseEntity<ApiResponse> updateDeliveryPartnerDetails(@PathVariable int id, @RequestBody DeliveryPartnerRequestDto dto){
       return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success("Delivery Partner updated ",_service.updateDetails(id,dto)));
    }


}
