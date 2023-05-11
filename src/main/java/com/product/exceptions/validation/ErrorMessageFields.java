package com.product.exceptions.validation;


import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindException;

import com.product.exceptions.ErrorMessage;

public class ErrorMessageFields extends ErrorMessage {
	private static final String DESCRIPTION = "Bad Request, Error de campos";

	private List<FieldError> fieldsError = new ArrayList<>();

	public ErrorMessageFields(BindException exception, String path) {

		super(exception.getClass().getSimpleName(), DESCRIPTION, path);
		this.setFieldsError(exception);
	}

	public List<FieldError> getFieldsError() {
		return fieldsError;
	}

	private void setFieldsError(BindException exception) {
		FieldError error;
		for (org.springframework.validation.FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
			error = new FieldError(fieldError.getField(), fieldError.getRejectedValue(),
					fieldError.getDefaultMessage());
			fieldsError.add(error);
		}
	}
}