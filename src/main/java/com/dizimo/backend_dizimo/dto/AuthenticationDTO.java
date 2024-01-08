package com.dizimo.backend_dizimo.dto;

public record AuthenticationDTO(String login, String password, CredentialsRole role) {

}
