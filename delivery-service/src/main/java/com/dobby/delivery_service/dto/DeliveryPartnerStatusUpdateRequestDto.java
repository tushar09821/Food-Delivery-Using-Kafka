package com.dobby.delivery_service.dto;

import com.dobby.delivery_service.util.PartnerAvailabliltyStatus;
import jakarta.validation.constraints.NotNull;

public class DeliveryPartnerStatusUpdateRequestDto {
    @NotNull(message = "Availability status is required")
    private PartnerAvailabliltyStatus availabilityStatus;

    public PartnerAvailabliltyStatus getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(PartnerAvailabliltyStatus availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }
}
