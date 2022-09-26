/*
infrateam and application team
 */
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { ServiceHelperService } from '../service-helper.service';
import { Order } from './models/order.interface';

@Injectable({
  providedIn: 'root'
})
export class OrdersService {
  orders: Order[] = [];
  constructor(private http: HttpClient,
              private svcHelper: ServiceHelperService) { }

  fetch(): Observable<Order[]> {
    const url = `${this.svcHelper.getUrl('order')}/orders`;
    return this.http.get<Order[]>(url);
  }

  get(orderId: string): Observable<Order> {
    const url = `${this.svcHelper.getUrl('order')}/order/${orderId}`;
    return this.http.get<Order>(url);
  }

  create(order: Order): Observable<Order> {
    const url = `${this.svcHelper.getUrl('order')}/order`;
    return this.http.post<Order>(url, order);
  }

}
