package com.example.itbaftest.service.vehiculo;

import com.example.itbaftest.dto.vehiculo.AutomovilDTO;
import com.example.itbaftest.dto.vehiculo.CotizacionDTO;
import com.example.itbaftest.model.exception.ExceptionApi;
import com.example.itbaftest.model.vehiculo.Automovil;
import com.example.itbaftest.model.vehiculo.Opcional;
import com.example.itbaftest.repository.vehiculo.AutomovilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutomovilService {

    private final AutomovilRepository automovilRepository;

    private final OptionalService optionalService;

    private final VarianteService varianteService;

    @Autowired
    public AutomovilService(AutomovilRepository automovilRepository, OptionalService optionalService, VarianteService varianteService) {
        this.automovilRepository = automovilRepository;
        this.optionalService = optionalService;
        this.varianteService = varianteService;
    }

    public Automovil nuevoAutomovil(AutomovilDTO automovilDTO){
        Automovil automovil=new Automovil();
        automovil.setVariante(this.varianteService.obtenerVarianteNombre(automovilDTO.getNombre()));
        automovilDTO.getOpcionales().forEach(nombre-> automovil.getOpcionales().add(this.optionalService.obtenerOpcionalByNombre(nombre)));
        return this.automovilRepository.save(automovil);
    }

    public Automovil modificarAutomovil(AutomovilDTO automovilDTO){
        this.automovilRepository.findById(automovilDTO.getId()).orElseThrow(()->new ExceptionApi(3001,"El automovil no esta registrado",automovilDTO.getId().toString()));
        Automovil automovil=new Automovil();
        automovil.setId(automovilDTO.getId());
        automovil.setVariante(this.varianteService.obtenerVarianteNombre(automovilDTO.getNombre()));
        automovilDTO.getOpcionales().forEach(nombre-> automovil.getOpcionales().add(this.optionalService.obtenerOpcionalByNombre(nombre)));
        return this.automovilRepository.save(automovil);
    }

    public void eliminarAutomovil(Long id){
        Automovil automovil=this.automovilRepository.findById(id).orElseThrow(()->new ExceptionApi(3001,"El automovil no esta registrado",id.toString()));
        this.automovilRepository.delete(automovil);
    }


    public Automovil getAutomovil(Long id) {
        return this.automovilRepository.findById(id).orElseThrow(()->new ExceptionApi(3001,"El automovil no esta registrado", id.toString()));
    }

    public List<Automovil> listAutomovil() {
        return this.automovilRepository.findAll();
    }

    public CotizacionDTO obtenerCotizacion(Long id) {
        Automovil automovil=this.automovilRepository.findById(id).orElseThrow(()->new ExceptionApi(3001,"El automovil no esta registrado", id.toString()));
        double valor=this.calcularCotizacion(automovil);
        CotizacionDTO cotizacionDTO=new CotizacionDTO();
        cotizacionDTO.setPrecio(valor);
        return cotizacionDTO;
    }

    public double calcularCotizacion(Automovil automovil) {
        Double valor=0d;
        valor+=automovil.getVariante().getPrecio();
        if(!automovil.getOpcionales().isEmpty()) {
            double valorOpciones=automovil.getOpcionales().stream().mapToDouble(Opcional::getPrecio).sum();
            valor+=valorOpciones;
        }
        return valor;
    }
}
