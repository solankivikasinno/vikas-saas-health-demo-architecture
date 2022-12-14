/*
infrateam and application team
 */
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Product } from '../../products/models/product.interface';
import { ProductService } from '../../products/product.service';
import { Order } from '../models/order.interface';
import { OrdersService } from '../orders.service';

interface LineItem {
  product: Product;
  quantity?: number;
}

@Component({
  selector: 'app-orders-create',
  templateUrl: './orders-create.component.html',
  styles: [
    '.dottedUnderline { border-bottom: 1px dotted; }',
  ]
})
export class OrdersCreateComponent implements OnInit {
  orderForm: FormGroup;
  orderProducts: LineItem[] = [];
  error: string;

  constructor(private fb: FormBuilder,
              private router: Router,
              private productSvc: ProductService,
              private orderSvc: OrdersService) { }

  ngOnInit(): void {
    this.productSvc.fetch().subscribe(products => {
      this.orderProducts = products.map(p => (
        { product: p }
      ));
    })
    this.orderForm = this.fb.group({
      name: ['', Validators.required],
    });
  }

  add(op: LineItem) {
    const orderProduct = this.orderProducts.find(p => p?.product.productId  === op.product.productId);
    this.orderProducts = this.orderProducts.map(p => {
      if (p.product?.productId === orderProduct.product?.productId) {
        p = {
          ...orderProduct,
          quantity: orderProduct.quantity ? orderProduct.quantity + 1 : 1,
        };
      }
      return p;
    });
  }

  remove(op: LineItem) {
    const orderProduct = this.orderProducts.find(p => p?.product.productId  === op.product.productId);
    this.orderProducts = this.orderProducts.map(p => {
      if (p.product?.productId === orderProduct.product?.productId) {
        p = {
          ...orderProduct,
          quantity: orderProduct.quantity && orderProduct.quantity > 1 ?
                      orderProduct.quantity - 1 : undefined,
        };
      }
      return p;
    });
  }

  submit() {
    const val: Order = {
      ...this.orderForm.value,
      orderProduct: this.orderProducts
      .filter(p => !!p.quantity)
      .map(p => ({
        productId: p.product.productId,
        price: p.product.price,
        quantity: p.quantity
      })),
    };
    this.orderSvc.create(val)
      .subscribe(() => {
        this.router.navigate(['orders']);
      },
      (err: string) => {
        this.error = err;
      });
  }

  cancel() {
    this.router.navigate(['orders']);
  }

}
