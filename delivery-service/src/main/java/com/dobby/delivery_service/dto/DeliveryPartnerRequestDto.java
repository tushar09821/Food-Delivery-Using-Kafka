package com.dobby.delivery_service.dto;

import com.dobby.delivery_service.util.PartnerAvailabliltyStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class DeliveryPartnerRequestDto {
    @NotBlank(message = "Name can not be blank")
    @Size(min = 2, max = 20, message = "Name must be between 2 and 20 characters")
    private String name;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be exactly 10 digits")
    private String phoneNumber;

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

    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Availability status is required")
    private PartnerAvailabliltyStatus availabilityStatus;
}
