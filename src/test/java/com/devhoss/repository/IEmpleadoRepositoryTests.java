package com.devhoss.repository;

import com.devhoss.DatosEmpleados;
import com.devhoss.model.Empleado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class IEmpleadoRepositoryTests {

    @Autowired
    private IEmpleadoRepository iempleadoRepository;

    private Empleado empleado;
    @BeforeEach
    void setup(){
        empleado = DatosEmpleados.empleado;
    }
    @DisplayName("Test para guardar un empleado")
    @Test
    void testGuardarEmpleado() {
        //given - dado o condición previa o configuración
        Empleado empleado1 = DatosEmpleados.empleadoGuardar;

        //when - acción o el comportamiento que vamos a probar
        Empleado empleadoGuardado = iempleadoRepository.save(empleado1);

        //then - verificar la salida
        assertThat(empleadoGuardado).isNotNull();
        //assertThat(empleadoGuardado.getId()).isGreaterThan(0);
    }

    @DisplayName("Test para listar a los empleados")
    @Test
    void testListarEmpleados(){
        //given
        Empleado empleado1 = DatosEmpleados.empleadoGuardar;
        iempleadoRepository.save(empleado1);
        iempleadoRepository.save(empleado);

        //when
        List<Empleado> listaEmpleados = iempleadoRepository.findAll();

        //then
        assertThat(listaEmpleados).isNotNull();
        assertThat(listaEmpleados.size()).isEqualTo(2);
    }

    @DisplayName("Test para obtener un empleado por ID")
    @Test
    void testObtenerEmpleadoPorId(){
        iempleadoRepository.save(empleado);

        //when - comportamiento o accion que vamos a probar
        Empleado empleadoBD = iempleadoRepository.findById(empleado.getId()).get();

        //then
        assertThat(empleadoBD).isNotNull();
    }


    @DisplayName("Test para actualizar un empleado")
    @Test
    void testActualizarEmpleado(){
        iempleadoRepository.save(empleado);

        //when
        Empleado empleadoGuardado = iempleadoRepository.findById(empleado.getId()).get();
        empleadoGuardado.setEmail("hhh-modificado@gmail.com");
        empleadoGuardado.setNombre("Hoss Hoss");
        empleadoGuardado.setApellido("VelascoA");
        Empleado empleadoActualizado = iempleadoRepository.save(empleadoGuardado);

        //then
        assertThat(empleadoActualizado.getEmail()).isEqualTo("hhh-modificado@gmail.com");
        assertThat(empleadoActualizado.getNombre()).isEqualTo("Hoss Hoss");
    }

    @DisplayName("Test para eliminar un empleado")
    @Test
    void testEliminarEmpleado(){
        iempleadoRepository.save(empleado);

        //when
        iempleadoRepository.deleteById(empleado.getId());
        Optional<Empleado> empleadoOptional = iempleadoRepository.findById(empleado.getId());

        //then
        assertThat(empleadoOptional).isEmpty();
    }

    @DisplayName("Test para obtener un empleado por ID")
    @Test
    void testObtenerEmpleadoPorDni(){
        iempleadoRepository.save(empleado);

        //when - comportamiento o accion que vamos a probar
        Empleado empleadoBD = iempleadoRepository.findByDni(empleado.getDni()).get();

        //then
        assertThat(empleadoBD).isNotNull();
        assertEquals(empleadoBD.getDni(),"12345678");
    }
}