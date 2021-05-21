package com.example.itbaftest.service.vehiculo;

import com.example.itbaftest.model.exception.ExceptionApi;
import com.example.itbaftest.model.vehiculo.Opcional;
import com.example.itbaftest.repository.vehiculo.OpcionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OptionalService {

    private final OpcionalRepository opcionalRepository;

    @Autowired
    public OptionalService(OpcionalRepository opcionalRepository) {
        this.opcionalRepository = opcionalRepository;
    }

    public Opcional obtenerOpcionalByNombre(String codigo){
        Optional<Opcional> opcionalOp=this.opcionalRepository.findByCodigo(codigo);
        return opcionalOp.orElseThrow(() -> new ExceptionApi(1000,"No existe el opcional",codigo));
    }
}
