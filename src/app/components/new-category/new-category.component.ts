import { Component, inject, model, OnInit } from '@angular/core';
import { Dialog } from '@angular/cdk/dialog';
import { NewCategoryCommand } from '../../interfaces/category.interface';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogTitle, MatDialogContent, MatDialogActions, MatDialogClose, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { DialogData, ListCategoriesComponent } from '../list-categories/list-categories.component';

@Component({
  selector: 'app-new-category',
  standalone: true,
  imports: [
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    MatButtonModule,
    MatDialogTitle,
    MatDialogContent,
    MatDialogActions,
    MatDialogClose,
  ],
  templateUrl: './new-category.component.html',
  styleUrl: './new-category.component.scss'
})
export class NewCategoryComponent extends Dialog implements OnInit{
  dialogRef = inject(MatDialogRef<NewCategoryComponent>);
  readonly data = inject<DialogData>(MAT_DIALOG_DATA);
  readonly name = model(this.data.name);
  edit: boolean = false;
  ngOnInit(): void {
    if(this.data.name)
      this.edit = true;
  }
  public criar(){
    this.data.name = this.name();
    this.dialogRef.close(this.data.name);
  }

}
