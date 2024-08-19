package br.com.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.products.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
