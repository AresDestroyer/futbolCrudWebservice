package com.babel.eduardo.mapper;

import org.mapstruct.Mapper;

import com.babel.eduardo.domain.Equipo;
import com.babel.eduardo.dto.EquipoDto;

@Mapper
public interface EquipoMapper {

    EquipoDto trasformar(Equipo team);

    Equipo transformar(EquipoDto dto);

}