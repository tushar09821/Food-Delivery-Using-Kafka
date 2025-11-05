package com.dobby.order_service.dto;

public class DeliveryRequestDto {
    private int orderId;
    private String pickupAddress;
    private String dropAddress;

    public DeliveryRequestDto(int orderId, String pickupAddress, String dropAddress) {
        this.orderId = orderId;
        this.pickupAddress = pickupAddress;
        this.dropAddress= dropAddress;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getPickupAddress() {
        return pickupAddress;
    }

    public void setPickupAddress(String pickupAddress) {
        this.pickupAddress = pickupAddress;
    }

    public String getDropAddress() {
        return dropAddress;
    }

    public void setDropAddress(String dropAddress) {
        this.dropAddress = dropAddress;
    }
}
