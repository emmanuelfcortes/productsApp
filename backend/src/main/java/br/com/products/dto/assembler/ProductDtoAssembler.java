package br.com.products.dto.assembler;

import org.springframework.stereotype.Component;

import br.com.products.command.NewProductCommand;
import br.com.products.dto.ProductDto;
import br.com.products.model.Product;

@Component
public class ProductDtoAssembler {
	CategoryDtoAssembler categoryDtoAssembler;
	
	public ProductDtoAssembler(CategoryDtoAssembler categoryDtoAssembler) {
		this.categoryDtoAssembler = categoryDtoAssembler;
	}
	public ProductDto toDto(Product product) {
		var categoryDto = categoryDtoAssembler.toDto(product.category());
		return new ProductDto(product.id(), product.name(), categoryDto);
	}
	
	public Product toEntity(ProductDto productDto) {
		var category = categoryDtoAssembler.toEntity(productDto.categoryDto());
		return new Product(productDto.id(), productDto.name(), category);
	}
	
	public Product toEntity(NewProductCommand command) {
		var category = categoryDtoAssembler.toEntity(command.categoryDto());
		return new Product(command.name(), category);
	}
	
}
