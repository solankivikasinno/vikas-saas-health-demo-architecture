/*
infrateam and application team
 */
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { ServiceHelperService } from '../service-helper.service';
import { Product } from './models/product.interface';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient,
    private svcHelper: ServiceHelperService) { }

  fetch(): Observable<Product[]> {
    const url = `${this.svcHelper.getUrl('product')}/products`;
    return this.http.get<Product[]>(url);
  }

  get(productId: string): Observable<Product> {
    const url = `${this.svcHelper.getUrl('product')}/product/${productId}`;
    return this.http.get<Product>(url);
  }

  delete(product: Product) {
    const url = `${this.svcHelper.getUrl('product')}/product/${product.productId}`;
    return this.http.delete<Product>(url);
  }

  put(product: Product) {
    const url = `${this.svcHelper.getUrl('product')}/product/${product.productId}`;
    return this.http.put<Product>(url, product);
  }

  post(product: Product) {
    const url = `${this.svcHelper.getUrl('product')}/product/`;
    return this.http.post<Product>(url, product);
  }
}
