package com.babel.eduardo.service.impl;

import java.util.List;

import com.babel.eduardo.dto.EquipoDto;

public interface EquipoService {

    Long crear(EquipoDto dto);

    EquipoDto buscar(long id);

    List<EquipoDto> buscarTodos();

    EquipoDto actualizar(EquipoDto dto);

    boolean eliminar(long id);

}