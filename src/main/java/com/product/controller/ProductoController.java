package com.product.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.product.dto.ProductoCreateDto;
import com.product.dto.ProductoDto;
import com.product.service.ProductoService;

//import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api" + ProductoController.PRODUCT)
@RequiredArgsConstructor
public class ProductoController {
    public static final String PRODUCT = "/productos";
    @Autowired
    private ProductoService service;

    @GetMapping
    public List<ProductoDto> all(@RequestParam(required = false) List<Long> ids) {
        return service.all(ids);
    }


    @GetMapping(value = {"/{id}"})
    public ProductoDto show(@PathVariable long id) {
        return service.show(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductoDto create(@Valid @RequestBody ProductoCreateDto customer) {
        return service.save(customer);
    }

    @PutMapping(value = {"/{id}"})
    public ProductoDto update(@Valid @RequestBody ProductoCreateDto body, @PathVariable Long id) {
        return service.update(id, body);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        this.service.delete(id);
    }



}
