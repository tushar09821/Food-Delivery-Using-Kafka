package com.dobby.restaurant_service.service;

import com.dobby.restaurant_service.dao.MenuItemsDao;
import com.dobby.restaurant_service.dao.RestaurantDao;
import com.dobby.restaurant_service.dto.MenuItemRequestDto;
import com.dobby.restaurant_service.dto.MenuItemResponseDto;
import com.dobby.restaurant_service.entity.MenuItems;
import com.dobby.restaurant_service.entity.Restaurant;
import com.dobby.restaurant_service.exception.ResourceNotFoundException;
import com.dobby.restaurant_service.util.ApiResponse;
import com.dobby.restaurant_service.util.MenuItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.ConditionalOnOAuth2ClientRegistrationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
public class MenuItemService {
    @Autowired
    private RestaurantService restService;

    @Autowired
    private MenuItemsDao menuItemsDao;

    @Autowired
    private MenuItemMapper mapper;

    public MenuItemResponseDto createMenuItem(int restId, MenuItemRequestDto menuItemRequestDto) {
        Restaurant restaurant = restService.getById(restId);
        MenuItems menuItem =  mapper.toEntity(menuItemRequestDto);
        menuItem.setRestaurant(restaurant);
        menuItemsDao.save(menuItem);

        return mapper.toResponse(menuItem);
    }
    public List<MenuItemResponseDto> getAllFoodItems(int restId){
        return mapper.toResponseList(menuItemsDao.findAllAvailableFoods(restId));
    }
    private MenuItems getById(int id){
        return  menuItemsDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu item not found"));
    }

    public MenuItemResponseDto updateMenuItem(int id, MenuItemRequestDto dto) {
        MenuItems menuItem = getById(id);
        mapper.updateEntityFromDto(dto,menuItem);
        return mapper.toResponse(menuItemsDao.save(menuItem));
    }

    public MenuItemResponseDto getMenuById(int id) {
        return mapper.toResponse(getById(id));
    }

    public MenuItemResponseDto deleteMenuItem(int restId, int menuId) {
        Restaurant restaurant = restService.getById(restId);
        MenuItems menuItems = getById(menuId);
        restaurant.getMenuItems().remove(menuItems);
        menuItemsDao.delete(menuItems);
        return mapper.toResponse(menuItems);
    }
}
