package com.product.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDto {
	private Long id;
    private String nombre;
    private String descripcion;
    private Double stock;
    private Double precio;
    private Date createAt;
}
