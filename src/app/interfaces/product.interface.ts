import { CategoryDto } from "./category.interface";

export interface ProductDto{
    id: number;
    name: string;
    categoryDto: CategoryDto

}

export interface NewProductCommand{
    name: string;
    categoryDto: CategoryDto
}
