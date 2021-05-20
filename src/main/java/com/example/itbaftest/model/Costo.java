package com.example.itbaftest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Costo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCosto;

    @NotNull
    private Double valor;

    public Long getIdCosto() {
        return idCosto;
    }

    public void setIdCosto(Long idCosto) {
        this.idCosto = idCosto;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
