package com.dobby.restaurant_service.util;

import com.dobby.restaurant_service.dto.MenuItemRequestDto;
import com.dobby.restaurant_service.dto.MenuItemResponseDto;
import com.dobby.restaurant_service.entity.MenuItems;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MenuItemMapper {

    MenuItems toEntity(MenuItemRequestDto dto);

    MenuItemResponseDto toResponse(MenuItems entity);

    List<MenuItemResponseDto> toResponseList(List<MenuItems> itemsList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(MenuItemRequestDto dto , @MappingTarget MenuItems items);
}
