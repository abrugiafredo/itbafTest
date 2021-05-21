package com.example.itbaftest.controller.vehiculo;

import com.example.itbaftest.dto.vehiculo.AutomovilDTO;
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
        return ResponseEntity.ok().body(this.automovilService.getAutomovil(id));
    }

    @GetMapping
    public List<Automovil> listAutomovil(){
        return this.automovilService.listAutomovil();
    }


    @PostMapping
    public ResponseEntity<Automovil> crearAutomovil(@RequestBody @Valid AutomovilDTO automovilDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.automovilService.nuevoAutomovil(automovilDTO));
    }
    @PutMapping
    public ResponseEntity<Automovil> modificarAutomovil(@RequestBody @Valid AutomovilDTO automovilDTO){
        return ResponseEntity.status(HttpStatus.OK).body(this.automovilService.modificarAutomovil(automovilDTO));
    }
    @DeleteMapping("/eliminar/{id}")
    public HttpStatus eliminarAutomovil(@PathVariable(value = "id") Long id){
        this.automovilService.eliminarAutomovil(id);
        return HttpStatus.OK;
    }

}
