package com.dizimo.backend_dizimo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "dizimistas")
public class Dizimista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String name;

    @Column(nullable = false)
    @NotBlank
    private LocalDate nascimento;

    @Column(nullable = false)
    @NotBlank
    private String bairro;

    @Column(nullable = false)
    @NotBlank
    private String rua;

    @Column(nullable = true)
    private Integer numero;

    @Column(nullable = true)
    private Boolean ativo;

    @Column(nullable = true)
    private String celular;

    public Dizimista(){}

    public Dizimista(Long id, String name, LocalDate nascimento, String bairro, String rua, Integer numero, Boolean ativo, String celular) {
        this.id = id;
        this.name = name;
        this.nascimento = nascimento;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.ativo = ativo;
        this.celular = celular;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dizimista dizimista)) return false;
        return getId().equals(dizimista.getId()) && getName().equals(dizimista.getName()) && getNascimento().equals(dizimista.getNascimento()) && getBairro().equals(dizimista.getBairro()) && getRua().equals(dizimista.getRua()) && getNumero().equals(dizimista.getNumero()) && getAtivo().equals(dizimista.getAtivo()) && getCelular().equals(dizimista.getCelular());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getNascimento(), getBairro(), getRua(), getNumero(), getAtivo(), getCelular());
    }
}

