package com.babel.eduardo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.babel.eduardo.domain.Equipo;

public interface EquipoRepository extends JpaRepository<Equipo, Long> {

	// select nombre,capacidadEstadio from Equipo order by capacidadEstadio desc
}