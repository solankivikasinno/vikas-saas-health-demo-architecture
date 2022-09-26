/*
infrateam and application team
 */
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from '../models/order.interface';
import { OrdersService } from '../orders.service';

@Component({
  selector: 'app-orders-list',
  templateUrl: './orders-list.component.html',
  styles: [
  ]
})
export class OrdersListComponent implements OnInit {
  orders: Observable<Order[]>;
  constructor(private orderSvc: OrdersService) { }


  ngOnInit(): void {
    this.orders = this.orderSvc.fetch();
  }

  sum(order: Order): number {
    return order.orderProduct
      .map(p => p.price * p.quantity)
      .reduce((acc, curr) => acc + curr);
  }
}
