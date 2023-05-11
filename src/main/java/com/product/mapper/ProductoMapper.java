package com.product.mapper;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.product.dto.ProductoCreateDto;
import com.product.dto.ProductoDto;
import com.product.entity.Producto;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductoMapper {
	
	@Autowired
	private final ModelMapper mapper;

    public ProductoDto entityToDto(Producto entity) {
        ProductoDto dto = mapper.map(entity, ProductoDto.class);
        return dto;
    }

    public Producto dtoToEntity(ProductoDto dto) {
        Producto entity = mapper.map(dto, Producto.class);
        return entity;
    }

    public Producto dtoCreateToEntity(ProductoCreateDto dto) {    	
        //Producto entity = mapper.map(dto, Producto.class);
        Producto entity = new Producto();
        entity.setNombre(dto.getNombre());
        entity.setDescripcion(dto.getDescripcion());
        entity.setCreateAt(Date.from(Instant.now()));
        entity.setPrecio(dto.getPrecio());
        entity.setStock(dto.getStock());
        return entity;
    }
}
