package com.dobby.restaurant_service.controller;

import com.dobby.restaurant_service.dto.RestaurantRequestDto;
import com.dobby.restaurant_service.service.RestaurantService;
import com.dobby.restaurant_service.util.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/lists")
    public ResponseEntity<ApiResponse> getAllRestaurants(){
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success("List of all restaurants",restaurantService.getAllRestaurants()));
    }

    @PostMapping()
    public ResponseEntity<ApiResponse> registerRestaurant(@Valid @RequestBody RestaurantRequestDto restaurantRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Registration Success",restaurantService.registerRestaurant(restaurantRequestDto)));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getRestaurantById(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body( ApiResponse.success("Restaurant Details ",restaurantService.getRestaurantById(id)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> deleteRestaurant(@PathVariable int id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ApiResponse.success("Deleted",null));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse> updateRestaurant(@PathVariable int id,@RequestBody RestaurantRequestDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success("Updated Details",restaurantService.updateRestaurant(id,dto)));
    }
    @PostMapping("/{restId}/give-rating")
    public ResponseEntity<ApiResponse> updateRating(@RequestParam int rate,@PathVariable int restId){
     return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success("Rating Updated ",restaurantService.updateRestaurantRating(restId,rate)));
    }

    @PostMapping("/order/{restId}/accept/{orderId}")
    public ResponseEntity<ApiResponse> acceptOrder(@PathVariable int restId, @PathVariable int orderId){
        // restId, OrderId
        // update Order status accepted
        // via interservice call to orderService.
        return  null;
    }







}
