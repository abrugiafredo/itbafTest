package com.example.itbaftest.dto.vehiculo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

public class AutomovilDTO {
    private Long id;

    @NotBlank(message = "El nombre es requerido")
    @NotEmpty(message = "El nombre es requerido")
    private String nombre;

    private Set<String> opcionales;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<String> getOpcionales() {
        if(this.opcionales==null){
            this.opcionales=new HashSet<>();
        }
        return opcionales;
    }

    public void setOpcionales(Set<String> opcionales) {
        this.opcionales = opcionales;
    }
}
