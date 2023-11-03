package com.dizimo.backend_dizimo.dto;

import com.dizimo.backend_dizimo.entities.Dizimista;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class OfetaDTO {
    @NotBlank
    private Double value;

    @NotBlank
    private String mesReferente;

    @NotBlank
    private LocalDate date;

    private String obs;
    private Dizimista dizimista;
}
