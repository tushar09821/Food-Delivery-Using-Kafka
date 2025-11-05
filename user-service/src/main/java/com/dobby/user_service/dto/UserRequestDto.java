package com.dobby.user_service.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
public class UserRequestDto {
    private String name;
    private String email;
    private String contact;
    private String address;
    private String type;

    public @NotBlank(message = "Name is a required field", groups = {Create.class}) @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters", groups = {Create.class, Update.class}) String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name is a required field", groups = {Create.class}) @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters", groups = {Create.class, Update.class}) String name) {
        this.name = name;
    }

    public @Email(message = "Email should be valid", groups = {Create.class, Update.class}) @NotBlank(message = "Email is required", groups = Create.class) String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Email should be valid", groups = {Create.class, Update.class}) @NotBlank(message = "Email is required", groups = Create.class) String email) {
        this.email = email;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
