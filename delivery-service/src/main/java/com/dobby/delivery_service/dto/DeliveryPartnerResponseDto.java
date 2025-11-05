package com.dobby.delivery_service.dto;

import com.dobby.delivery_service.entity.Delivery;
import com.dobby.delivery_service.util.PartnerAvailabliltyStatus;

import java.util.List;

public class DeliveryPartnerResponseDto {
    private int id;
    private String name;
    private String phoneNumber;
    private String email;
    private PartnerAvailabliltyStatus availabilityStatus;
    private List<Delivery> deliveries;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PartnerAvailabliltyStatus getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(PartnerAvailabliltyStatus availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }
}
