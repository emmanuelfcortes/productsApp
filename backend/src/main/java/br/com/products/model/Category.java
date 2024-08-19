package br.com.products.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table(name = "categories", schema = "db")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "categories_sq")
	@SequenceGenerator(schema = "db",name = "categories_sq")
	Long id;
	
	String name;
	
	public Category() {}
	public Category(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Category(String name) {
		this.name = name;
	}
	
	
	public Long id() {
		return this.id;
	}
	
	public void id(Long id) {
		this.id = id;
	}
	
	public String name() {
		return this.name;
	}
	public void name(String name) {
		this.name = name;
	}
}
