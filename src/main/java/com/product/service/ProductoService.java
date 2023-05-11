package com.product.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.dto.ProductoCreateDto;
import com.product.dto.ProductoDto;
import com.product.entity.Categoria;
import com.product.entity.Producto;
import com.product.exceptions.NotFoundException;
import com.product.mapper.ProductoMapper;
import com.product.repository.CategoriaRepository;
import com.product.repository.ProductoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoService {
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
    private ProductoMapper mapper;
    
	
    public ProductoDto save(ProductoCreateDto body) {
        Producto ProductoEntity = mapper.dtoCreateToEntity(body);
        
        Long categoriaId = body.getCategoriaId();
        Categoria categoriaEntity = findCategoriaId(categoriaId);
        //ProductoEntity.setCategoria(new Categoria().builder().id(body.getCategoriaId()).build());
        ProductoEntity.setCategoria(categoriaEntity);
        productoRepository.save(ProductoEntity);
        System.out.println("producto"+ProductoEntity);
        ProductoDto dto = mapper.entityToDto(ProductoEntity);
        return dto;
    }

    
    public ProductoDto show(Long id) {
        Producto Producto = productoRepository.findById(id).orElseThrow(() -> new NotFoundException("Producto id (" + id + ")"));
        ProductoDto dto = mapper.entityToDto(Producto);

        return dto;
    }

    
    public List<ProductoDto> all(List<Long>ids) {
        List<Producto> Productos;
        if(ids == null) {
            Productos = productoRepository.findAll();
        }else {
            Productos = productoRepository.findAllById(ids);
        }

        List<ProductoDto> dtos = Productos.stream().map(mapper::entityToDto).collect(Collectors.toList());
        return dtos;
    }

    public ProductoDto update(Long id, ProductoCreateDto ProductoCreateDto) {
        Producto Producto = productoRepository.findById(id).orElseThrow(() -> new NotFoundException("Producto id (" + id + ")"));
        Producto.setNombre(ProductoCreateDto.getNombre());
        Producto.setStock(ProductoCreateDto.getStock());
        Producto.setDescripcion(ProductoCreateDto.getDescripcion());
        Producto.setCategoria(new Categoria().builder().id(ProductoCreateDto.getCategoriaId()).build());
        productoRepository.save(Producto);
        ProductoDto dto = mapper.entityToDto(Producto);
        return dto;
    }

    public void delete(Long id) {
        assertProductoExists(id);
        productoRepository.deleteById(id);
    }
    
    public void assertProductoExists(Long id) {
        productoRepository.findById(id).orElseThrow(()->new NotFoundException("Producto no encontrado: "+id));
    }
    
    private Categoria findCategoriaId(Long id) {
    	Categoria categoria = categoriaRepository.findById(id).orElseThrow(() -> new NotFoundException("Categoria id (" + id + ")"));
    	return categoria;
    }
    
}
