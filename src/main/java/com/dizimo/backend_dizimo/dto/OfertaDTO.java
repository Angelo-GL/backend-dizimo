package com.dizimo.backend_dizimo.dto;

import com.dizimo.backend_dizimo.entities.Dizimista;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class OfertaDTO {
    @NotNull
    private Double value;
    @NotBlank
    private String mesReferente;
    private LocalDate date;
    private String obs;
    private Dizimista dizimista;

    public OfertaDTO() {
    }

    public OfertaDTO(Double value, String mesReferente, LocalDate date, String obs, Dizimista dizimista) {
        this.value = value;
        this.mesReferente = mesReferente;
        this.date = date;
        this.obs = obs;
        this.dizimista = dizimista;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getMesReferente() {
        return mesReferente;
    }

    public void setMesReferente(String mesReferente) {
        this.mesReferente = mesReferente;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Dizimista getDizimista() {
        return dizimista;
    }

    public void setDizimista(Dizimista dizimista) {
        this.dizimista = dizimista;
    }
}
