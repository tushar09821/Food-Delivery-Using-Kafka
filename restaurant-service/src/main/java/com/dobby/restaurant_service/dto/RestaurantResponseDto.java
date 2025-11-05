package com.dobby.restaurant_service.dto;

import com.dobby.restaurant_service.entity.MenuItems;

import java.util.ArrayList;
import java.util.List;

public class RestaurantResponseDto {
    private int id;
    private String name;
    private String contact;
    private String address;
    private float rating;
    private List<MenuItemResponseDto> menuItems = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public List<MenuItemResponseDto> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItemResponseDto> menuItems) {
        this.menuItems = menuItems;
    }
}
