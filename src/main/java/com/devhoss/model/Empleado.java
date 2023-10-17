package com.devhoss.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "empleados")
public class Empleado {


   // @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
   // private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nombre",nullable = false)
    private String nombre;

    @Column(name = "apellido",nullable = false)
    private String apellido;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "dni",nullable = false)
    private String dni;
}