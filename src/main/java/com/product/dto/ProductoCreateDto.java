package com.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductoCreateDto{
	
	@NotBlank
    private String nombre;
    private String descripcion;
    private Double stock;
    private Double precio;
    @NotNull
    private Long categoriaId;
}
