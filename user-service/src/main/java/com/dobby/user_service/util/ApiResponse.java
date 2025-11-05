package com.dobby.user_service.util;

public class ApiResponse<T> {
    private boolean status;
    private String message;
    private T data;
    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<T>(true, message, data);
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ApiResponse(boolean status,  String message,T data) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public ApiResponse() {
    }
}
