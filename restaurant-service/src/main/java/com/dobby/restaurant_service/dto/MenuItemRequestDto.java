package com.dobby.restaurant_service.dto;

public class MenuItemRequestDto {
    public MenuItemRequestDto() {
    }

    public MenuItemRequestDto(String name, Double price, boolean available) {
        this.name = name;
        this.price = price;
        this.available = available;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    private Double price;
    private boolean available;
}
