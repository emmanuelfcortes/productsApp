package br.com.products.application;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.products.command.NewCategoryCommand;
import br.com.products.dto.CategoryDto;
import br.com.products.dto.assembler.CategoryDtoAssembler;
import br.com.products.repository.CategoryRepository;

@Service
public class CategoryApplicationService {
	CategoryRepository repository;
	CategoryDtoAssembler assembler;
	
	public CategoryApplicationService(CategoryRepository repository, CategoryDtoAssembler assembler) {
		this.repository = repository;
		this.assembler = assembler;
	}
	
	public CategoryDto create(NewCategoryCommand command) {
		var newCategory = repository.save(assembler.toEntity(command));
		return assembler.toDto(newCategory);
	}
	
	public List<CategoryDto> findAll() {
		return repository.findAll().stream()
				.map(category -> assembler.toDto(category))
				.toList();
	}
	
	public CategoryDto findById(Long id) {
		var product = repository.findById(id).orElseThrow();
		return assembler.toDto(product);
	}
	
	public CategoryDto update(CategoryDto categoryDto) {
		var category = repository.findById(categoryDto.id()).orElseThrow();
		category = assembler.toEntity(categoryDto);
		repository.saveAndFlush(category);
		return assembler.toDto(category);
	}
	
	public CategoryDto delete(Long id) {
		var category = repository.findById(id).orElseThrow();
		repository.delete(category);
		return assembler.toDto(category);
	}
	
}
