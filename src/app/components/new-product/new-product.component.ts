import { Component, inject, model, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatOptionModule, MatOptionSelectionChange } from '@angular/material/core';
import { MatDialogTitle, MatDialogContent, MatDialogActions, MatDialogClose, MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { matFormFieldAnimations, MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import {MatSelectModule } from '@angular/material/select'
import { DialogData } from '../list-products/list-products.component';
import { Dialog } from '@angular/cdk/dialog';
import { CategoryService } from '../../services/category.service';
import { BrowserAnimationsModule, NoopAnimationsModule } from '@angular/platform-browser/animations';

@Component({
  selector: 'app-new-product',
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
    MatInputModule,
    MatOptionModule,
    MatSelectModule,
    
  ],
  templateUrl: './new-product.component.html',
  styleUrl: './new-product.component.css'
})

export class NewProductComponent extends Dialog implements OnInit{
  dialogRef = inject(MatDialogRef<NewProductComponent>);
  readonly data = inject<DialogData>(MAT_DIALOG_DATA);
  readonly name = model(this.data.name);
  categoryId = this.data.category?.id
  readonly categories = this.data.categories;
  public ngOnInit(): void {
    
  }
  public criar(){
    let categoryDto = this.categories.find(cat => cat.id == this.categoryId);
    this.dialogRef.close({name: this.name(), category: categoryDto});
  }

}

