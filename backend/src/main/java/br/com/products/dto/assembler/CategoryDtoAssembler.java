package br.com.products.dto.assembler;

import org.springframework.stereotype.Component;

import br.com.products.command.NewCategoryCommand;
import br.com.products.command.NewProductCommand;
import br.com.products.dto.CategoryDto;
import br.com.products.model.Category;
import br.com.products.model.Product;

@Component
public class CategoryDtoAssembler {
	public CategoryDto toDto(Category category) {
		return new CategoryDto(category.id(), category.name());
	}
	public Category toEntity(CategoryDto categoryDto) {
		return new Category(categoryDto.id(), categoryDto.name());
	}
	
	public Category toEntity(NewCategoryCommand command) {
		return new Category(command.name());
	}
}
