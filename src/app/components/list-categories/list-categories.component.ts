import { Component, inject, OnInit, signal, Signal} from '@angular/core';
import { CategoryService } from '../../services/category.service';
import { CategoryDto } from '../../interfaces/category.interface';
import { AppModule } from '../../app.module';
import {
  MAT_DIALOG_DATA,
  MatDialog,
  MatDialogActions,
  MatDialogClose,
  MatDialogContent,
  MatDialogRef,
  MatDialogTitle,
} from '@angular/material/dialog';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatTableModule} from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { NewCategoryComponent } from '../new-category/new-category.component';

export interface DialogData {
  name: string;
}

@Component({
  selector: 'app-list-categories',
  standalone: true,
  imports: [MatFormFieldModule, MatInputModule, MatButtonModule, MatTableModule],
  templateUrl: './list-categories.component.html',
  styleUrl: './list-categories.component.scss'
})

export class ListCategoriesComponent implements OnInit {
  constructor(private _categoryService: CategoryService){}
  categories: CategoryDto[] = [];
  dialog = inject(MatDialog);
  displayedColumns = ["id", "name","actions"];
  
  ngOnInit(): void {
    this._categoryService.findAll().subscribe((categories) =>{
      this.categories = categories;
    })
  }
  public editar(category: CategoryDto){
    this.nova(category);
  }
  public excluir(category: CategoryDto){
    this._categoryService.delete(category.id).subscribe(() =>{
      this.ngOnInit();
    },(e)=> 
      alert('Erro ao excluir a categoria. Caso haja algum produto nesta categoria, ela não poderá ser excluída.'));
  }

  public nova(category?: CategoryDto){
    let dialogRef = this.dialog.open(NewCategoryComponent, {
      height: '400px',
      width: '300px',
      data: {name: category?.name}});

    dialogRef.afterClosed().subscribe(result => {
      
      if(category){
       
        if (result && result != "" && result != category.name) {
        
          category.name = result;
          this._categoryService.update(category).subscribe(()=>{
            alert('Categoria editada com sucesso!');
            this.ngOnInit();
          }, (e)=>{
            alert('Erro ao editar categoria. ');
          })
          this.ngOnInit();
        }
      }
      else {
        if(result && result != ""){
          
          this._categoryService.create({name: result}).subscribe(()=>{
            alert('Categoria criada com sucesso!');
            this.ngOnInit();
          },(e)=>{
            alert('Erro ao criar a categoria.');
          })
        }
      }

    });
  }
}
