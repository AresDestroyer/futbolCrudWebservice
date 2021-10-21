package com.babel.eduardo.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EquipoDto {
    private Long id;
    private String nombre;
    private String ciudad;
    private String propietario;
    private Integer capacidadEstadio;
    private String division;
    private String competicion;
    private Integer jugadores;
    private LocalDate fechaCreacion;
}