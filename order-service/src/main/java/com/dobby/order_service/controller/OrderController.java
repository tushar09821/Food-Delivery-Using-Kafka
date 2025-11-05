package com.dobby.order_service.controller;

import com.dobby.order_service.dto.OrderRequestDto;
import com.dobby.order_service.dto.OrderStatusUpdate;
import com.dobby.order_service.service.OrderService;
import com.dobby.order_service.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getOrderById(@PathVariable int id){

        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success("Order Details",service.getOrderById(id)));
    }
    @PostMapping
    public ResponseEntity<ApiResponse> createOrder(@RequestBody OrderRequestDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success("Order Created",service.createOrder(dto)));
    }
    @PatchMapping("/{id}/update-status")
    public ResponseEntity<ApiResponse> updateOrderStatus(@PathVariable int id, @RequestBody OrderStatusUpdate status){
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success("Order Status Updated",service.updateOrderStatus(id,status))) ;
    }
    @GetMapping("/{userId}/user-orders")
    public ResponseEntity<ApiResponse> getOrderOfUser(@PathVariable int userId){
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success("List of Orders",service.getOrdersByUserId(userId)));
    }
    // for testing purpose
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteOrder(@PathVariable int orderId){
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success("Deleted SuccessFully",service.delete(orderId)));
    }

}
