package com.dobby.delivery_service.dto;

import com.dobby.delivery_service.util.DeliveryStatus;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

public class DeliveryStatusDto {
    @NotNull(message = "Availability status is required")
    private DeliveryStatus status;

    public DeliveryStatus getStatus() {
        return status;
    }

    public void setStatus(DeliveryStatus status) {
        this.status = status;
    }
}
