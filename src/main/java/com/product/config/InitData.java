package com.product.config;

import java.util.List;

import com.product.repository.CategoriaRepository;
import com.product.repository.ProductoRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.product.entity.Categoria;
import com.product.entity.Producto;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class InitData implements CommandLineRunner {

    private final Logger log = LoggerFactory.getLogger(InitData.class);
    private final CategoriaRepository CategoriaRepository;
    private final ProductoRepository ProductoRepository;

    @Override
    public void run(String... args) throws Exception {

        Categoria CategoriaA = new Categoria().builder().nombre("Categoria A").build();
        Categoria CategoriaB = new Categoria().builder().nombre("Categoria B").build();
        Categoria CategoriaC = new Categoria().builder().nombre("Categoria C").build();

        CategoriaRepository.saveAll(List.of(CategoriaA, CategoriaB, CategoriaC));

        Producto ProductoA = new Producto().builder().nombre("Producto A").precio(25D).stock(10D).categoria(CategoriaA).build();
        Producto ProductoB = new Producto().builder().nombre("Producto B").precio(15D).stock(1D).categoria(CategoriaA).build();
        Producto ProductoC = new Producto().builder().nombre("Producto C").precio(5D).stock(2D).categoria(CategoriaB).build();

        ProductoRepository.saveAll(List.of(ProductoA, ProductoB, ProductoC));

        log.info("Categorias Creadas "+CategoriaRepository.findAll());
        log.info("Productoos Creados "+ProductoRepository.findAll());

    }


}
