/*
infrateam and application team
 */
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { map, switchMap } from 'rxjs/operators';
import { ServiceHelperService } from '../../service-helper.service';
import { Order } from '../models/order.interface';
import { OrderProduct } from '../models/orderproduct.interface';
import { OrdersService } from '../orders.service';

@Component({
  selector: 'app-orders-detail',
  templateUrl: './orders-detail.component.html',
  styleUrls: [ './orders-detail.component.scss'  ]
})
export class OrdersDetailComponent implements OnInit {
  orderId$: Observable<string>;
  order$: Observable<Order>;
  orderProducts$: Observable<OrderProduct[]>;
  taxRate = .0899;
  constructor(private route: ActivatedRoute,
              private orderSvc: OrdersService,
              private helperSvc: ServiceHelperService) { }

  ngOnInit(): void {

    this.orderId$ = this.route.params.pipe(
      map(o => o.orderId)
    );

    this.order$ = this.orderId$.pipe(
      switchMap(o => this.orderSvc.get(o))
    );

    this.orderProducts$ = this.order$.pipe(
      map(o => o.orderProduct)
    )
  }

  today() {
    return new Date();
  }

  tenantName() {
    return this.helperSvc.getTenantName();
  }

  sum(op: OrderProduct) {
    return op.price * op.quantity;
  }

  tax(op: OrderProduct) {
    return this.sum(op) * this.taxRate;
  }

  total(op: OrderProduct) {
    return this.sum(op) + this.tax(op);
  }

  subTotal(order: Order) {
    return order.orderProduct
      .map(op => op.price * op.quantity)
      .reduce((acc, curr) => acc + curr);
  }

  calcTax(order: Order) {
    return this.subTotal(order) * this.taxRate;
  }

  final(order: Order) {
    return this.subTotal(order) + this.calcTax(order);
  }


}
