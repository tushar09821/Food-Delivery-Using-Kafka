package com.dobby.delivery_service.entity;

import com.dobby.delivery_service.util.PartnerAvailabliltyStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
public class DeliveryPartner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phoneNumber;
    private String email;
    @Enumerated(EnumType.STRING)
    private PartnerAvailabliltyStatus availabilityStatus;

    @OneToMany(mappedBy = "deliveryPartner",cascade = CascadeType.ALL)
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
