package com.babel.eduardo.validador;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.babel.eduardo.dto.EquipoDto;

public class DtoValidator implements ConstraintValidator<CheckDto, EquipoDto> {

    @Override
    public boolean isValid(EquipoDto value, ConstraintValidatorContext context) {

	boolean valido = true;

	if (!value.getFechaCreacion().isBefore(LocalDate.now())) {
	    valido = false;
	    context.buildConstraintViolationWithTemplate("La fecha de creación debe ser anterior a la de hoy")
		    .addPropertyNode("fechaCreacion").addConstraintViolation();
	}

	if (value.getDivision() == 1 && value.getCapacidadEstadio() <= 50000) {
	    valido = false;
	    context.buildConstraintViolationWithTemplate("La capacidad para la división 1 debe ser mayor de 50000")
		    .addPropertyNode("capacidadEstadio").addConstraintViolation();
	}
	if (value.getDivision() == 2 && value.getCapacidadEstadio() <= 10000) {
	    valido = false;
	    context.buildConstraintViolationWithTemplate("La capacidad para la división 2 debe ser mayor de 10000")
		    .addPropertyNode("capacidadEstadio").addConstraintViolation();
	}
	if (value.getDivision() == 3 && value.getCapacidadEstadio() <= 3000) {
	    valido = false;
	    context.buildConstraintViolationWithTemplate("La capacidad para la división 3 debe ser mayor de 3000")
		    .addPropertyNode("capacidadEstadio").addConstraintViolation();
	}

	return valido;
    }

}