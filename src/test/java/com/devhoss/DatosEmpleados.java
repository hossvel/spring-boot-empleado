package com.devhoss;

import com.devhoss.model.Empleado;

import java.util.List;
import java.util.UUID;

public class DatosEmpleados {

    public final static List<Empleado> listaEmpleados =
            List.of(
                    Empleado.builder()

                            .id(UUID.fromString("7523365d-646e-4bd9-bf67-4fa9539fdd2c"))
                            .nombre("Hernan")
                            .apellido("Velasco")
                            .email("he@gmail.com")
                            .dni("24681357")
                            .build(),
                    Empleado.builder()
                            .id(UUID.randomUUID())
                            .nombre("otro")
                            .apellido("otro")
                            .email("oo@gmail.com")
                            .dni("87654321")
                            .build()

            );

    public final static Empleado empleado =
            Empleado.builder()
                    .id(UUID.fromString("f8c3de3d-1fea-4d7c-a8b0-29f63c4c3454"))
                    .nombre("Hossmell")
                    .apellido("Velasco")
                    .email("hh@gmail.com")
                    .dni("12345678")
                    .build();
}
