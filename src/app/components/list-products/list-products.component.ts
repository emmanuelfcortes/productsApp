import { Component, inject, OnInit } from '@angular/core';
import { ProductService } from "../../../app/services/product.service";
import { NewProductCommand, ProductDto } from '../../interfaces/product.interface';
import { CommonModule } from '@angular/common';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { MatMenuModule } from '@angular/material/menu';
import {MatButtonModule} from'@angular/material/button';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterOutlet } from '@angular/router';
import { ListCategoriesComponent } from '../list-categories/list-categories.component';
import { AppModule } from '../../app.module';
import { CategoryDto } from '../../interfaces/category.interface';
import { NewProductComponent } from '../new-product/new-product.component';
import { CategoryService } from '../../services/category.service';
import { MatTableModule } from '@angular/material/table';

export interface DialogData {
  name: string;
  category: CategoryDto;
  categories: CategoryDto[]
}
@Component({
  selector: 'app-list-products',
  standalone: true,
  imports:[MatButtonModule, MatTableModule], 
  templateUrl: './list-products.component.html',
  styleUrl: './list-products.component.scss'
})
export class ListProductsComponent implements OnInit{
  displayedColumns = ["id","name","category","actions"];
  constructor(
    private _productService: ProductService, 
    private _categoryService: CategoryService
  ){}
  products: ProductDto[] = [];
  categories: CategoryDto[] = [];
  dialog = inject(MatDialog);
  
  
  ngOnInit(): void {
    this._productService.findAll().subscribe((products: ProductDto[]) =>{
      this.products = products;
    })
    this._categoryService.findAll().subscribe((categories: CategoryDto[]) =>{
      this.categories = categories;
    })
  }
  public editar(product: ProductDto){
    this.novo(product);
  }
  public excluir(product: ProductDto){
    this._productService.delete(product.id).subscribe((products) =>{
      this.ngOnInit();
    },(e)=> alert('Erro ao excluir o produto.'+ e));
  }
  public novo(product?: ProductDto){
    let dialogRef = this.dialog.open(NewProductComponent, {
      height: '400px',
      width: '300px',
      data: {
        name: product?.name,
        category: product?.categoryDto,
        categories: this.categories
      }});

    dialogRef.afterClosed().subscribe(result => {
      
      if(product){
        if (result && result?.name != product.name || result.category.name != product.categoryDto.name) {
          product.name = result.name;
          product.categoryDto = result.category;
          this._productService.update(product).subscribe(()=>{
            alert('Produto editado com sucesso!');
            this.ngOnInit();
          }, (e)=>{
            alert('Erro ao editar produto. '+e);
          })
          this.ngOnInit();
        }
      }
      else {
        if(result && result != ""){
          let command : NewProductCommand = {name: result?.name, categoryDto: result?.category}
          this._productService.create(command).subscribe(()=>{
            alert('Produto criado com sucesso!');
            this.ngOnInit();
          },(e)=>{
            alert('Erro ao criar produto. ');
          })
        }
      }

    });
  }
}
