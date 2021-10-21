package com.babel.eduardo.dto;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.babel.eduardo.validador.CheckDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@CheckDto
public class EquipoDto {
    private Long id;
    @NotBlank
    private String nombre;
    private String ciudad;
    private String propietario;
    @Min(1)
    private Integer capacidadEstadio;
    @Min(1)
    @Max(3)
    private Integer division;

    private String competicion;
    @Min(1)
    private Integer jugadores;
    private LocalDate fechaCreacion;
}