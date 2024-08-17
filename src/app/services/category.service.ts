import { Injectable } from '@angular/core';
import { CategoryDto, NewCategoryCommand } from '../interfaces/category.interface';
import { Observable} from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
@Injectable({
  providedIn: 'root',
})
export class CategoryService {

  constructor(private _httpClient: HttpClient) { 
  }
  private urlBase = "http://localhost:8080/categorias";
  
  public  findAll(): Observable<CategoryDto[]>{
    return this._httpClient.get<CategoryDto[]>(this.urlBase);
  }
  
  public  delete(id:number): Observable<CategoryDto>{
    return this._httpClient.delete<CategoryDto>(this.urlBase+"/"+id);
  }

  public  create(command: NewCategoryCommand): Observable<CategoryDto>{
    return this._httpClient.post<CategoryDto>(this.urlBase,command);
  }

  public  update(category: CategoryDto): Observable<CategoryDto>{
    return this._httpClient.put<CategoryDto>(this.urlBase,category);
  }

}
