package br.com.products.interfaces;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.products.application.ProductApplicationService;
import br.com.products.command.NewProductCommand;
import br.com.products.dto.ProductDto;

@CrossOrigin
@RestController
@RequestMapping("/api/produtos")


public class ProductRestResource {
	ProductApplicationService service;
	public ProductRestResource(ProductApplicationService service) {
		this.service = service;
	}
	
	@GetMapping("")
	public List<ProductDto> findAllProducts() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> findProduct(@PathVariable Long id) {
		try {
			return new ResponseEntity(service.findById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("")
	public ResponseEntity<ProductDto> createProduct(@RequestBody NewProductCommand command) {
		try {
			return new ResponseEntity(service.create(command), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
		}
	}	
	
	@PutMapping("")
	public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto) {
		try {
			return new ResponseEntity(service.update(productDto), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ProductDto> deleteById(@PathVariable Long id) {
		try {
			return new ResponseEntity(service.delete(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
}
