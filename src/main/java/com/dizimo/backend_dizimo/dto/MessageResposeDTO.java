package com.dizimo.backend_dizimo.dto;

public class MessageResposeDTO {
    private  String message;

    public MessageResposeDTO() {};

    public MessageResposeDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
