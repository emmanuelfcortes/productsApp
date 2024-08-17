import { CommonModule } from "@angular/common";
import { HttpClientModule } from "@angular/common/http";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { ListCategoriesComponent } from "./components/list-categories/list-categories.component";
import { ListProductsComponent } from "./components/list-products/list-products.component";
import { AppComponent } from "./app.component";
import { MatButtonModule } from "@angular/material/button";
import { MatCommonModule } from "@angular/material/core";
import { MatDialog, MatDialogModule } from "@angular/material/dialog";


@NgModule({
    imports:[
        CommonModule,
        HttpClientModule,
        FormsModule,
        ReactiveFormsModule,
        ListCategoriesComponent,
        ListProductsComponent,
        MatButtonModule,
        MatCommonModule,
        MatDialogModule,
        AppComponent
    ],
    exports:[
        CommonModule,
        HttpClientModule,
        FormsModule,
        ReactiveFormsModule,
        ListCategoriesComponent,
        ListProductsComponent,
        MatButtonModule,
        MatCommonModule,
        MatDialogModule,
        AppComponent
    ],
    declarations:[
        
    ],
    bootstrap: []

})
export class AppModule{}