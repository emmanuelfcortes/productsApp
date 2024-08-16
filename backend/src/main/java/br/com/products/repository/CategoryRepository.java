package br.com.products.repository;


import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.products.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	
}
