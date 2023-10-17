package com.devhoss.service;

import com.devhoss.model.Empleado;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IEmpleadoService {

    List<Empleado> getAllEmpleados();
    Optional<Empleado> getEmpleadoById(UUID id);
}
