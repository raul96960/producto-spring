package com.product.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;

import com.product.dto.CategoriaCreateDto;
import com.product.dto.CategoriaDto;
import com.product.service.CategoriaService;

//import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api" + CategoriaController.CATEGORY)
public class CategoriaController {
	
	public static final String CATEGORY = "/categorias";
	
	@Autowired
    private CategoriaService service;
	
	
    @GetMapping
    public List<CategoriaDto> all() {
        return service.all();
    }

    
    @GetMapping(value = {"/{id}"})
    public CategoriaDto show(@PathVariable long id) {
        return service.show(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoriaDto create(@Valid @RequestBody CategoriaCreateDto customer) {
        return service.save(customer);
    }

    @PutMapping(value = {"/{id}"})
    public CategoriaDto update(@Valid @RequestBody CategoriaCreateDto body, @PathVariable Long id) {
        return service.update(id, body);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        this.service.delete(id);
    }
}
