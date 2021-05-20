package com.example.itbaftest.service.vehiculo;

import com.example.itbaftest.model.exception.ExceptionApi;
import com.example.itbaftest.model.vehiculo.Variante;
import com.example.itbaftest.repository.vehiculo.VarianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VarianteService {

    private final VarianteRepository varianteRepository;

    @Autowired
    public VarianteService(VarianteRepository varianteRepository) {
        this.varianteRepository = varianteRepository;
    }


    public Variante obtenerVarianteNombre(String nombre){
        Optional<Variante> varianteOp=this.varianteRepository.findByNombre(nombre);

        return varianteOp.orElseThrow(()->new ExceptionApi(2000,"No se encontro la variante",nombre));
    }
}
