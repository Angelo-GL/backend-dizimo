package com.dizimo.backend_dizimo.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class CredentialsDTO {
    @NotBlank
    @Email
    private String login;
    @NotBlank
    private String password;
    @NotBlank
    private CredentialsRole role;

    public CredentialsDTO() {
    }

    public CredentialsDTO(String login, String password, CredentialsRole role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CredentialsRole getRole() {
        return role;
    }

    public void setRole(CredentialsRole role) {
        this.role = role;
    }
}
