package com.dobby.delivery_service.dto;

import com.dobby.delivery_service.entity.Delivery;
import com.dobby.delivery_service.util.DeliveryStatus;
import jakarta.validation.constraints.NotBlank;

public class DeliveryRequestDto {
    private int orderId;
    private String pickupAddress;
    private String dropAddress;
    private DeliveryStatus status;

    public DeliveryStatus getStatus() {
        return status;
    }

    public void setStatus(DeliveryStatus status) {
        this.status = status;
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
