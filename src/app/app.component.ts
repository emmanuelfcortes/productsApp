import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ListCategoriesComponent } from "./components/list-categories/list-categories.component";
import { ListProductsComponent } from './components/list-products/list-products.component'
import {MatMenuModule} from '@angular/material/menu';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import {CommonModule} from '@angular/common';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ExtraOptions, PreloadAllModules, RouterModule} from '@angular/router';
import {MAT_DIALOG_DEFAULT_OPTIONS, MatDialogModule} from '@angular/material/dialog';
import { AppModule } from './app.module';
import { MatButtonModule } from '@angular/material/button';
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [ MatButtonModule,
    ListCategoriesComponent,
    ListProductsComponent,
    AppModule], 
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'product-app';
}
