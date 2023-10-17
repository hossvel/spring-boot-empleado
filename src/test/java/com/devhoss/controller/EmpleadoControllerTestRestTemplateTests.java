package com.devhoss.controller;

import com.devhoss.DatosEmpleados;
import com.devhoss.model.Empleado;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmpleadoControllerTestRestTemplateTests {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private ObjectMapper objectMapper;

    @LocalServerPort
    private int puerto;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }
    @Test
    @Order(1)
    void testGuardarEmpleado(){
        Empleado empleado = DatosEmpleados.empleadoGuardar;

        ResponseEntity<Empleado> respuesta = testRestTemplate.postForEntity(crearUri("/api/empleados"), empleado, Empleado.class);
        assertEquals(HttpStatus.CREATED,respuesta.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON,respuesta.getHeaders().getContentType());

        Empleado empleadoCreado = respuesta.getBody();
        assertNotNull(empleadoCreado);

        assertEquals("Dayni",empleadoCreado.getNombre());
        assertEquals("Quispe",empleado.getApellido());
        assertEquals("dd@gmail.com",empleadoCreado.getEmail());
        assertEquals("23456789",empleadoCreado.getDni());
    }

    @Test
    @Order(2)
    void testListarEmpleados(){
        ResponseEntity<Empleado[]> respuesta = testRestTemplate.getForEntity(crearUri("/api/empleados"),Empleado[].class);
        List<Empleado> empleados = Arrays.asList(respuesta.getBody());

        assertEquals(HttpStatus.OK,respuesta.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON,respuesta.getHeaders().getContentType());

        assertEquals(3,empleados.size());
       // assertEquals(1L,empleados.get(0).getId());
       // assertEquals("Christian",empleados.get(0).getNombre());
       // assertEquals("Ramirez",empleados.get(0).getApellido());
       // assertEquals("c1@gmail.com",empleados.get(0).getEmail());
    }

    private String crearUri(String uri) {
        return "http://localhost:" + puerto + uri;
    }

}