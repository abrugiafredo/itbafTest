package com.example.itbaftest.repository.vehiculo;

import com.example.itbaftest.model.vehiculo.Costo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostoRepository extends JpaRepository<Costo,Long> {
}
