package com.devhoss.controller;

import com.devhoss.model.Empleado;
import com.devhoss.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {


    @Autowired
    private IEmpleadoService iempleadoService;

    @GetMapping
    public List<Empleado> listarEmpleados(){
        return iempleadoService.getAllEmpleados();
    }
}
