package com.devhoss.service;

import com.devhoss.model.Empleado;
import com.devhoss.repository.IEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{

    @Autowired
    private IEmpleadoRepository iempleadoRepository;
    @Override
    public List<Empleado> getAllEmpleados() {
        return iempleadoRepository.findAll();
    }
}
