package com.product.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.product.dto.CategoriaCreateDto;
import com.product.dto.CategoriaDto;
import com.product.entity.Categoria;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CategoriaMapper {
	
	@Autowired
	private final ModelMapper mapper;

    public CategoriaDto entityToDto(Categoria entity){
        CategoriaDto dto = mapper.map(entity, CategoriaDto.class);
        return dto;
    }

    public Categoria dtoToEntity(CategoriaDto dto){
        Categoria entity = mapper.map(dto, Categoria.class);
        return entity;
    }
    
    public Categoria dtoCreateToEntity(CategoriaCreateDto dto){
        Categoria entity = mapper.map(dto, Categoria.class);
        return entity;
    }
	
}
