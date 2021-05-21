package com.example.itbaftest.model.vehiculo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Opcional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOpcional;

    @NotBlank
    @NotEmpty
    private String codigo;

    @NotBlank
    @NotEmpty
    private String nombre;

    @NotNull
    private Double precio;


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getIdOpcional() {
        return idOpcional;
    }

    public void setIdOpcional(Long idOpcional) {
        this.idOpcional = idOpcional;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
