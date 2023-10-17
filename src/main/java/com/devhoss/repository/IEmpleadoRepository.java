package com.devhoss.repository;

import com.devhoss.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface IEmpleadoRepository extends JpaRepository<Empleado, UUID> {

    Optional<Empleado> findByEmail(String email);
    Optional<Empleado> findByDni(String dni);
}