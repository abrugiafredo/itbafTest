package com.example.itbaftest.controller.vehiculo;

import com.example.itbaftest.model.vehiculo.Automovil;
import com.example.itbaftest.service.vehiculo.AutomovilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
