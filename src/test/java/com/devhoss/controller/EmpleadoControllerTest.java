package com.devhoss.controller;


import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


import com.devhoss.model.Empleado;
import com.devhoss.service.IEmpleadoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@WebMvcTest
class EmpleadoControllerTest {

    /*
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IEmpleadoService iempleadoService;

    @Autowired
    private ObjectMapper objectMapper;
    @Test
    void listarEmpleados() throws Exception {
        //given
        List<Empleado> listaEmpleados = new ArrayList<>();
        listaEmpleados.add(Empleado.builder().nombre("Christian").apellido("Ramirez").email("c1@gmail.com").build());
        listaEmpleados.add(Empleado.builder().nombre("Gabriel").apellido("Ramirez").email("g1@gmail.com").build());
        listaEmpleados.add(Empleado.builder().nombre("Julen").apellido("Ramirez").email("cj@gmail.com").build());
        listaEmpleados.add(Empleado.builder().nombre("Biaggio").apellido("Ramirez").email("b1@gmail.com").build());
        listaEmpleados.add(Empleado.builder().nombre("Adrian").apellido("Ramirez").email("a@gmail.com").build());
        given(iempleadoService.getAllEmpleados()).willReturn(listaEmpleados);

        //when
        ResultActions response = mockMvc.perform(get("/api/empleados"));

        //then
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()",is(listaEmpleados.size())));

    }
    */

}