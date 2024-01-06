package com.dizimo.backend_dizimo.dto;

public enum CredentialsRole {
    ADMIN("admin"),
    USER("user");

    private String role;

    CredentialsRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
