import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { NewProductCommand, ProductDto } from '../interfaces/product.interface';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private _httpClient: HttpClient) { 
  }
  private urlBase = "http://localhost:8080/produtos";
  
  public  findAll(): Observable<ProductDto[]>{
    return this._httpClient.get<ProductDto[]>(this.urlBase);
  }

  public  delete(id:number): Observable<ProductDto>{
    return this._httpClient.delete<ProductDto>(this.urlBase+"/"+id);
  }

  public  create(command: NewProductCommand): Observable<ProductDto>{
    return this._httpClient.post<ProductDto>(this.urlBase,command);
  }

  public  update(product: ProductDto): Observable<ProductDto>{
    return this._httpClient.put<ProductDto>(this.urlBase,product);
  }
}
