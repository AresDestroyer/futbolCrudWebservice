package com.babel.eduardo.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Table
@Entity
public class Equipo {

	private String nombre;
	private String ciudad;
	private String propietario;
	private int capacidadEstadio;
	private String división;
	private String competición;
	private int jugadores;
	private LocalDateTime fechaCreación;
}
