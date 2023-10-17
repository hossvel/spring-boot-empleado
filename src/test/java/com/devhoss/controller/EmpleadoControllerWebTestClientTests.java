package com.devhoss.controller;
import com.devhoss.DatosEmpleados;
import com.devhoss.model.Empleado;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmpleadoControllerWebTestClientTests {

    @Autowired
    private WebTestClient webTestClient;

    @LocalServerPort
    private int puerto;
    @Test
    @Order(1)
    void testGuardarEmpleado(){
        //given
        Empleado empleado = DatosEmpleados.empleadoGuardar;

        //when
        webTestClient.post().uri(crearUri("/api/empleados"))
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(empleado)
                .exchange() //envia el request

                //then
                .expectStatus().isCreated()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.nombre").isEqualTo(empleado.getNombre())
                .jsonPath("$.apellido").isEqualTo(empleado.getApellido())
                .jsonPath("$.email").isEqualTo(empleado.getEmail());
    }


    @Test
    @Order(2)
    void testObtenerEmpleadoPorId(){
        //webTestClient.get().uri("http://localhost:8080/api/empleados/3").exchange()
        webTestClient.get().uri(crearUri("/api/empleados/f8c3de3d-1fea-4d7c-a8b0-29f63c4c3454")).exchange()
                .expectStatus().isNotFound();

    }


    @Test
    @Order(3)
    void testListarEmpleados(){
        webTestClient.get().uri("/api/empleados").exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()

                .jsonPath("$").isArray();

    }


    private String crearUri(String uri) {
        return "http://localhost:" + puerto + uri;
    }



}