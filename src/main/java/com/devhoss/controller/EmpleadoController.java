package com.devhoss.controller;

import com.devhoss.model.Empleado;
import com.devhoss.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {


    @Autowired
    private IEmpleadoService iempleadoService;

    @GetMapping
    public List<Empleado> listarEmpleados(){
        return iempleadoService.getAllEmpleados();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable("id") UUID id){
        System.out.println(id);
        return iempleadoService.getEmpleadoById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
