package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.product.entity.Categoria;
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
	@Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM Producto p WHERE p.categoria.id = :id")
    public boolean hasProducts(Long id);
	
}
