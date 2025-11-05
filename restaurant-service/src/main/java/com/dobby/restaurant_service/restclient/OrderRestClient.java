package com.dobby.restaurant_service.restclient;


import com.dobby.restaurant_service.util.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface OrderRestClient {
    public ResponseEntity<ApiResponse> getAllPendingOrders(int id);
}
