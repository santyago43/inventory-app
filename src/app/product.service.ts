import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Product } from './product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private urlBase = "http://localhost:8080/inventory-app/products";

  constructor(private clientHttp: HttpClient) { }

  getProductList(): Observable<Product[]>{
    return this.clientHttp.get<Product[]>(this.urlBase);
  }

  addProduct(product: Product): Observable<Object>{
    return this.clientHttp.post(this.urlBase, product);
  }

  obtainProductById(id: number){
    return this.clientHttp.get<Product>(`${this.urlBase}/${id}`);
  }

  editProduct(id: number, product: Product): Observable<Object>{
    return this,this.clientHttp.put(`${this.urlBase}/${id}`, product);
  }

  deleteProduct(id: number): Observable<Object>{
    return this.clientHttp.delete(`${this.urlBase}/${id}`);
  }
}
