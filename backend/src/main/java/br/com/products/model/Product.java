package br.com.products.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "products", schema = "db")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "products_sq")
	@SequenceGenerator(schema = "db",name = "products_sq")
	Long id;
	
	String name;
	
	@ManyToOne
	Category category;
	
	public Product() {}
	public Product(Long id, String name, Category category) {
		this.id = id;
		this.name = name;
		this.category = category;
	}
	
	public Product(String name, Category category) {
		this.name = name;
		this.category = category;
	}
	
	
	public Long id() {
		return id;
	}

	public void id(Long id) {
		this.id = id;
	}

	public String name() {
		return name;
	}

	public void name(String name) {
		this.name = name;
	}

	public Category category() {
		return category;
	}

	public void category(Category category) {
		this.category = category;
	}

	
	
}
