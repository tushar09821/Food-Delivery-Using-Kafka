package com.dobby.restaurant_service.service;

import com.dobby.restaurant_service.dao.RestaurantDao;
import com.dobby.restaurant_service.dto.RestaurantRequestDto;
import com.dobby.restaurant_service.dto.RestaurantResponseDto;
import com.dobby.restaurant_service.entity.Restaurant;
import com.dobby.restaurant_service.exception.ResourceNotFoundException;
import com.dobby.restaurant_service.restclient.OrderRestClient;
import com.dobby.restaurant_service.util.ApiResponse;
import com.dobby.restaurant_service.util.RestaurantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantDao restaurantDao;

    @Autowired
    private RestaurantMapper mapper;

    protected Restaurant getById(int id ){
        return restaurantDao.findById(id).orElseThrow(()-> new ResourceNotFoundException("Restaurant with id "+ id +"not found"));
    }

    public List<RestaurantResponseDto> getAllRestaurants() {
       return mapper.toResponseList(restaurantDao.findAll());
    }
    public RestaurantResponseDto getRestaurantById(int id){
        return mapper.toResponseDto(getById(id));
    }
    public RestaurantResponseDto registerRestaurant(RestaurantRequestDto dto){
        Restaurant restaurant = mapper.toEntity(dto);
        return mapper.toResponseDto(restaurantDao.save(restaurant));
    }

    public void deleteRestaurant(int id) {
        Restaurant restaurant = getById(id);
        restaurantDao.delete(restaurant);
    }
    public RestaurantResponseDto updateRestaurant(int id, RestaurantRequestDto restaurantRequestDto){
        Restaurant restaurant = getById(id);
        mapper.updateRestaurantFromDto(restaurantRequestDto, restaurant);
        return mapper.toResponseDto(restaurantDao.save(restaurant));
    }
    public RestaurantResponseDto updateRestaurantRating(int id, int rating){
        Restaurant restaurant = getById(id);
        restaurant.setRatingSum(restaurant.getRatingSum() + rating);
        restaurant.setRatingCount(restaurant.getRatingCount() + 1);
        float average = (float) restaurant.getRatingSum() / restaurant.getRatingCount();
        restaurant.setRating(average);
        return mapper.toResponseDto(restaurantDao.save(restaurant));

    }
}
