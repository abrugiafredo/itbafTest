package com.example.itbaftest.controller.vehiculo;

import com.example.itbaftest.dto.vehiculo.AutomovilDTO;
import com.example.itbaftest.dto.vehiculo.CotizacionDTO;
import com.example.itbaftest.model.vehiculo.Automovil;
import com.example.itbaftest.service.vehiculo.AutomovilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController()
@RequestMapping("/api/automovil")
public class AutomovilController {

    private final AutomovilService automovilService;

    @Autowired
    public AutomovilController(AutomovilService automovilService) {
        this.automovilService = automovilService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Automovil> getAutomovil(@PathVariable(value = "id") Long id){
        Automovil automovil=this.automovilService.getAutomovil(id);
        automovil.setPrecio(this.automovilService.calcularCotizacion(automovil));
        return ResponseEntity.ok().body(automovil);
    }
    @GetMapping("/cotizacion/{id}")
    public ResponseEntity<CotizacionDTO> obtenerCotizacion(@PathVariable(value = "id") Long id){

        return ResponseEntity.ok().body(this.automovilService.obtenerCotizacion(id));
    }

    @GetMapping
    public List<Automovil> listAutomovil(){
        List<Automovil> automovils=this.automovilService.listAutomovil();
        automovils.forEach(a->a.setPrecio(this.automovilService.calcularCotizacion(a)));
        return automovils;
    }


    @PostMapping
    public ResponseEntity<Automovil> crearAutomovil(@RequestBody @Valid AutomovilDTO automovilDTO){
        Automovil automovil=this.automovilService.nuevoAutomovil(automovilDTO);
        automovil.setPrecio(this.automovilService.calcularCotizacion(automovil));
        return ResponseEntity.status(HttpStatus.CREATED).body(automovil);
    }
    @PutMapping
    public ResponseEntity<Automovil> modificarAutomovil(@RequestBody @Valid AutomovilDTO automovilDTO){
        Automovil automovil=this.automovilService.modificarAutomovil(automovilDTO);
        automovil.setPrecio(this.automovilService.calcularCotizacion(automovil));
        return ResponseEntity.status(HttpStatus.OK).body(automovil);
    }
    @DeleteMapping("/eliminar/{id}")
    public HttpStatus eliminarAutomovil(@PathVariable(value = "id") Long id){
        this.automovilService.eliminarAutomovil(id);
        return HttpStatus.OK;
    }

}
