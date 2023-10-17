package com.devhoss.repository;

import com.devhoss.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IEmpleadoRepository extends JpaRepository<Empleado,Long> {

    Optional<Empleado> findByEmail(String email);
}