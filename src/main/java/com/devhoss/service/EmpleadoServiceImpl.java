package com.devhoss.service;

import com.devhoss.exception.ResourceNotFoundException;
import com.devhoss.model.Empleado;
import com.devhoss.repository.IEmpleadoRepository;
import com.devhoss.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{

    @Autowired
    private IEmpleadoRepository iempleadoRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public List<Empleado> getAllEmpleados() {
        return iempleadoRepository.findAll();
    }

    @Override
    public Optional<Empleado> getEmpleadoById(UUID id) {
        return iempleadoRepository.findById(id);
    }

    @Override
    public Empleado saveEmpleado(Empleado empleado) {
        Optional<Empleado> empleadoexiste = iempleadoRepository.findByDni(empleado.getDni());
        if(empleadoexiste.isPresent()){
            throw new ResourceNotFoundException("El empleado con ese dni ya existe : " + empleado.getDni());
        }


        Empleado empleadosave = iempleadoRepository.save(empleado);

        //TODO: Send message to order topic
       // kafkaTemplate.send("empleados-topic",empleadosave.getDni(), JsonUtils.toJson(empleadosave) );

        return empleadosave;
    }

    @Override
    public Empleado updateEmpleado(Empleado empleado) {
        return iempleadoRepository.save(empleado);
    }

    @Override
    public void deleteEmpleado(UUID id) {
        iempleadoRepository.deleteById(id);
    }
}
