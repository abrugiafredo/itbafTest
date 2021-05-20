package com.example.itbaftest.repository.vehiculo;

import com.example.itbaftest.model.vehiculo.Variante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VarianteRepository extends JpaRepository<Variante,Long> {
    Optional<Variante> findByNombre(String nombre);
}
