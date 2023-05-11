package com.product.dto;

import javax.validation.constraints.NotBlank;

//import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaCreateDto {
	@NotBlank
	private String nombre;
}
