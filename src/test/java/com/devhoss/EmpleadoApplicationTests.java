package com.devhoss;

import com.devhoss.model.Empleado;
import com.devhoss.repository.IEmpleadoRepository;
import com.devhoss.service.EmpleadoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EmpleadoApplicationTests {



	@Mock
	IEmpleadoRepository iEmpleadoRepository;

	@InjectMocks
	EmpleadoServiceImpl empleadoServiceImpl;

	private Empleado empleado;

	@BeforeEach
	void setup(){
		empleado = DatosEmpleados.empleado;
	}

	@DisplayName("Test para retornar una lista vacia")
	@Test
	void testListarColeccionEmpleadosVacia() {

		//given
		given(iEmpleadoRepository.findAll()).willReturn(Collections.emptyList());
		//when
		List<Empleado> fraudes = empleadoServiceImpl.getAllEmpleados();

		//then
		assertThat(fraudes).isEmpty();
		assertThat(fraudes.size()).isEqualTo(0);
		assertEquals(0,fraudes.size());

		verify(iEmpleadoRepository).findAll();

	}
	@DisplayName("Test para listar empleados")
	@Test
	void testListarEmpleados(){
		//given

		given(iEmpleadoRepository.findAll()).willReturn(DatosEmpleados.listaEmpleados);

		//when
		List<Empleado> empleados = empleadoServiceImpl.getAllEmpleados();

		//then
		assertThat(empleados).isNotNull();
		assertThat(empleados.size()).isEqualTo(2);

		verify(iEmpleadoRepository).findAll();
	}


	@DisplayName("Test para obtener un empleado por ID")
	@Test
	void testObtenerEmpleadoPorId(){
		//given
		given(iEmpleadoRepository.findById(UUID.fromString("f8c3de3d-1fea-4d7c-a8b0-29f63c4c3454")))
				.willReturn(Optional.of(empleado));

		//when
		Empleado empleadoBuscado = empleadoServiceImpl.getEmpleadoById(empleado.getId()).get();

		//then
		assertThat(empleadoBuscado).isNotNull();
		verify(iEmpleadoRepository).findById(UUID.fromString("f8c3de3d-1fea-4d7c-a8b0-29f63c4c3454"));
	}

	@Test
	void testPreguntasExamenId() {


	}

}
