package com.babel.eduardo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.babel.eduardo.dto.EquipoDto;
import com.babel.eduardo.service.impl.EquipoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/equipo")
@Validated
public class EquipoController {

    private final EquipoService equipoService;

    @GetMapping
    public ResponseEntity<List<EquipoDto>> buscarTodos() {
	List<EquipoDto> equipo = equipoService.buscarTodos();
	return ResponseEntity.ok(equipo);

    }

    @GetMapping("/{id}")

    public ResponseEntity<EquipoDto> buscar(@RequestParam long id) {
	EquipoDto equipo = equipoService.buscar(id);
	if (equipo == null) {
	    return ResponseEntity.notFound().build();
	} else {
	    return ResponseEntity.ok(equipo);
	}
    }

    @PostMapping
    public ResponseEntity<Long> crear(@Valid @RequestBody EquipoDto dto) {

	dto.setId(null);
	Long id = equipoService.crear(dto);
	return ResponseEntity.ok(id);
    }

    @PutMapping
    public ResponseEntity<EquipoDto> actualizar(@Valid @RequestBody EquipoDto dto) {
	EquipoDto equipo = equipoService.actualizar(dto);
	if (equipo == null) {
	    return ResponseEntity.notFound().build();
	} else {
	    return ResponseEntity.accepted().body(equipo);
	}
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@RequestParam long id) {

	boolean eliminado = equipoService.eliminar(id);
	if (eliminado) {
	    return ResponseEntity.noContent().build();
	} else {
	    return ResponseEntity.notFound().build();
	}
    }
}
