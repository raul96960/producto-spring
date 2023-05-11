package com.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.entity.Categoria;
import com.product.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
	public List<Producto> findByCategoria(Categoria category);
}
