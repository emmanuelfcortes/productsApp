package br.com.products.command;

import br.com.products.dto.CategoryDto;

public record NewProductCommand(String name, CategoryDto categoryDto) {

}
