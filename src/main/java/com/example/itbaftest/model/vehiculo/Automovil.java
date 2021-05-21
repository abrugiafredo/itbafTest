package com.example.itbaftest.model.vehiculo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Automovil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Variante variante;

    @ManyToMany
    @JoinTable(name="automovil_opcional",
            joinColumns={@JoinColumn(name="id_automovil")},
            inverseJoinColumns={@JoinColumn(name="id_opcional")})
    private Set<Opcional> opcionales;


    @Transient
    private Double precio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Variante getVariante() {
        return variante;
    }

    public void setVariante(Variante variante) {
        this.variante = variante;
    }

    public Set<Opcional> getOpcionales() {
        if(this.opcionales==null){
            this.opcionales=new HashSet<>();
        }
        return opcionales;
    }

    public void setOpcionales(Set<Opcional> opcionales) {
        this.opcionales = opcionales;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
