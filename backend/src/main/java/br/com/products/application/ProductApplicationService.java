package br.com.products.application;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.products.command.NewProductCommand;
import br.com.products.dto.ProductDto;
import br.com.products.dto.assembler.ProductDtoAssembler;
import br.com.products.repository.ProductRepository;

@Service
public class ProductApplicationService {
	ProductRepository repository;
	ProductDtoAssembler assembler;
	
	public ProductApplicationService(ProductRepository repository, ProductDtoAssembler assembler) {
		this.repository = repository;
		this.assembler = assembler;
	}
	
	public ProductDto create(NewProductCommand command) {
		var newProduct = repository.save(assembler.toEntity(command));
		return assembler.toDto(newProduct);
	}
	
	public List<ProductDto> findAll() {
		return repository.findAll().stream()
				.map(prod -> assembler.toDto(prod))
				.toList();
	}
	
	public ProductDto findById(Long id) {
		var product = repository.findById(id).orElseThrow();
		return assembler.toDto(product);
	}
	
	
	public ProductDto update(ProductDto productDto) {
		var product = repository.findById(productDto.id()).orElseThrow();
		product = assembler.toEntity(productDto);
		repository.saveAndFlush(product);
		return assembler.toDto(product);
	}
	
	public ProductDto delete(Long id) {
		var product = repository.findById(id).orElseThrow();
		repository.delete(product);
		return assembler.toDto(product);
	}
	
	
}
