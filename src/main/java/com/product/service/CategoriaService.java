package com.product.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.dto.CategoriaCreateDto;
import com.product.dto.CategoriaDto;
import com.product.entity.Categoria;
import com.product.exceptions.ConstraintViolationException;
import com.product.exceptions.NotFoundException;
import com.product.mapper.CategoriaMapper;
import com.product.repository.CategoriaRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class CategoriaService {

	@Autowired
	private final CategoriaRepository repository;

	@Autowired
	private CategoriaMapper mapper;

	public CategoriaDto save(CategoriaCreateDto CategoriaCreateDto) {
		Categoria category = mapper.dtoCreateToEntity(CategoriaCreateDto);
		CategoriaDto dto = mapper.entityToDto(repository.save(category));
		return dto;
	}


	public CategoriaDto show(Long id) {
		Categoria category = repository.findById(id).orElseThrow(() -> new NotFoundException("Categoria id (" + id + ")"));
		CategoriaDto dto = mapper.entityToDto(category);
		return dto;
	}


	public List<CategoriaDto> all() {
		List<Categoria> categories = repository.findAll();
		List<CategoriaDto> dtos = categories.stream().map(mapper::entityToDto).collect(Collectors.toList());
		return dtos;
	}


	public CategoriaDto update(Long id, CategoriaCreateDto CategoriaCreateDto) {
		Categoria category = repository.findById(id).orElseThrow(() -> new NotFoundException("Categoria id (" + id + ")"));
		category.setNombre(CategoriaCreateDto.getNombre());
		repository.save(category);
		CategoriaDto dto = mapper.entityToDto(category);
		return dto;
	}

	public void delete(Long id) {
		assertProductosIsEmpty(id);
		assertCategoriaExists(id);
		repository.deleteById(id);
	}

	public void assertProductosIsEmpty(Long id) {
		if(repository.hasProducts(id)){
			throw new ConstraintViolationException("Hay productos con esta categoría");
		}
	}
	public void assertCategoriaExists(Long id) {
		repository.findById(id).orElseThrow(()->new NotFoundException("Categoría no encontrada: "+id));
	}

}
