package com.dizimo.backend_dizimo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table(name = "ofertas")
public class Oferta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double value;

    @Column(nullable = false)
    private String mesReferente;

    @Column(nullable = true)
    private LocalDate date;

    @Column(nullable = true)
    private String obs;
    @ManyToOne
    @JoinColumn(name = "dizimista_id")
    @JsonIgnore
    private Dizimista dizimista;

    public Oferta () {}
    public Oferta(Long id, Double value, String mesReferente, LocalDate date, String obs, Dizimista dizimista) {
        this.id = id;
        this.value = value;
        this.mesReferente = mesReferente;
        this.date = date;
        this.obs = obs;
        this.dizimista = dizimista;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Oferta oferta)) return false;
        return Objects.equals(getId(), oferta.getId()) && Objects.equals(getValue(), oferta.getValue()) && Objects.equals(getMesReferente(), oferta.getMesReferente()) && Objects.equals(getDate(), oferta.getDate()) && Objects.equals(getObs(), oferta.getObs()) && Objects.equals(getDizimista(), oferta.getDizimista());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getValue(), getMesReferente(), getDate(), getObs(), getDizimista());
    }
}
