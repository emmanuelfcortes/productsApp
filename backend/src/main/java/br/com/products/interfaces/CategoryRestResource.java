package br.com.products.interfaces;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.products.application.CategoryApplicationService;
import br.com.products.command.NewCategoryCommand;
import br.com.products.dto.CategoryDto;

@RestController
public class CategoryRestResource {
	CategoryApplicationService service;
	public CategoryRestResource(CategoryApplicationService service) {
		this.service = service;
	}
	
	@GetMapping("/categorias")
	public List<CategoryDto> findAllProducts() {
		return service.findAll();
	}
	
	@GetMapping("/categorias/{id}")
	public ResponseEntity<CategoryDto> findCategory(@PathVariable Long id) {
		try {
			return new ResponseEntity(service.findById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/categorias")
	public ResponseEntity<CategoryDto> createCategory(@RequestBody NewCategoryCommand command) {
		try {
			return new ResponseEntity(service.create(command), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
		}
	}	
	
	@PutMapping("/categorias")
	public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto) {
		try {
			return new ResponseEntity(service.update(categoryDto), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/categorias/{id}")
	public ResponseEntity<CategoryDto> deleteById(@PathVariable Long id) {
		try {
			return new ResponseEntity(service.delete(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
		}
	}
}
