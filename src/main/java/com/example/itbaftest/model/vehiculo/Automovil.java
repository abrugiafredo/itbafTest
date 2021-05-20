package com.example.itbaftest.model.vehiculo;

import javax.persistence.*;
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
        return opcionales;
    }

    public void setOpcionales(Set<Opcional> opcionales) {
        this.opcionales = opcionales;
    }
}
