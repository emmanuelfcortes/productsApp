import { Component, inject, model } from '@angular/core';
import { AppModule } from '../../app.module';
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
  styleUrl: './new-category.component.css'
})
export class NewCategoryComponent extends Dialog{
  dialogRef = inject(MatDialogRef<NewCategoryComponent>);
  readonly data = inject<DialogData>(MAT_DIALOG_DATA);
  readonly name = model(this.data.name);

  public criar(){
    this.data.name = this.name();
    this.dialogRef.close(this.data.name);
  }

}
