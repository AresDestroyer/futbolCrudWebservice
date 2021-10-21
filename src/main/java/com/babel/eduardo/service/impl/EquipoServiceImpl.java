package com.babel.eduardo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.babel.eduardo.domain.Equipo;
import com.babel.eduardo.dto.EquipoDto;
import com.babel.eduardo.mapper.EquipoMapper;
import com.babel.eduardo.repository.EquipoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EquipoServiceImpl implements EquipoService {

    private final EquipoMapper equipoMapper;
    private final EquipoRepository equipoRepository;

    @Override
    public Long crear(EquipoDto dto) {
	Equipo entidad = equipoMapper.transformar(dto);
	return equipoRepository.save(entidad).getId();
    }

    @Override
    public EquipoDto buscar(long id) {
	Equipo equipoBd = equipoRepository.findById(id).orElse(null);
	return equipoMapper.trasformar(equipoBd);
    }

    @Override
    public List<EquipoDto> buscarTodos() {
	return equipoRepository.findAll().stream().map(equipoMapper::trasformar).collect(Collectors.toList());
    }

    @Override
    public EquipoDto actualizar(EquipoDto dto) {

	Optional<Equipo> equipoBd = equipoRepository.findById(dto.getId());

	if (!equipoBd.isPresent()) {
	    return null;
	}

	Equipo equipo = equipoMapper.transformar(dto);

	equipoRepository.save(equipo);

	return equipoMapper.trasformar(equipo);
    }

    @Override
    public boolean eliminar(long id) {

	if (!equipoRepository.findById(id).isPresent()) {
	    return false;
	}

	equipoRepository.deleteById(id);
	return true;
    }

}