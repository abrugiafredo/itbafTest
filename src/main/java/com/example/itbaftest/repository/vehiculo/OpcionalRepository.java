package com.example.itbaftest.repository.vehiculo;

import com.example.itbaftest.model.vehiculo.Opcional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OpcionalRepository extends JpaRepository<Opcional,Long> {
    Optional<Opcional> findByCodigo(String codigo);
}
