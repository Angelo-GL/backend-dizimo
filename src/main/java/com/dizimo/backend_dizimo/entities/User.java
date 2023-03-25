package com.dizimo.backend_dizimo.entities;

public class User {
    private Long id;
    private String name;
    private String email;
    private String passWord;
    private String cpf;

    public  User () {}
    public User(Long id, String name, String email, String passWord, String cpf) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.passWord = passWord;
        this.cpf = cpf;
    }
}
