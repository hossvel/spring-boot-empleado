package com.devhoss;

import com.devhoss.model.Empleado;
import com.devhoss.repository.IEmpleadoRepository;
import com.devhoss.service.EmpleadoServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

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
		Empleado empleado1 = Empleado.builder()
				.id(2L)
				.nombre("Julen")
				.apellido("Oliva")
				.email("j2@gmail.com")
				.build();
		Empleado empleado2 = Empleado.builder()
				.id(2L)
				.nombre("Hoss")
				.apellido("velasco")
				.email("hh@gmail.com")
				.build();
		given(iEmpleadoRepository.findAll()).willReturn(List.of(empleado1,empleado2));

		//when
		List<Empleado> fraudes = empleadoServiceImpl.getAllEmpleados();

		//then
		assertThat(fraudes).isNotNull();
		assertThat(fraudes.size()).isEqualTo(2);

		verify(iEmpleadoRepository).findAll();
	}
}
