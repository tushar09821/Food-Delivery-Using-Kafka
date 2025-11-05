package com.dobby.restaurant_service.util;

import com.dobby.restaurant_service.dto.MenuItemResponseDto;
import com.dobby.restaurant_service.dto.RestaurantRequestDto;
import com.dobby.restaurant_service.dto.RestaurantResponseDto;
import com.dobby.restaurant_service.entity.MenuItems;
import com.dobby.restaurant_service.entity.Restaurant;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateRestaurantFromDto(RestaurantRequestDto dto, @MappingTarget Restaurant entity);

    Restaurant toEntity(RestaurantRequestDto dto);

    @Mapping(target = "menuItems", source = "menuItems")
    RestaurantResponseDto toResponseDto(Restaurant restaurant);

    MenuItemResponseDto toDto(MenuItems item);

    List<RestaurantResponseDto> toResponseList(List<Restaurant> list);
}
