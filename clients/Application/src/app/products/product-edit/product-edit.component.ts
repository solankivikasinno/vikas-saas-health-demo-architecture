/*
infrateam and application team
 */
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { map, switchMap } from 'rxjs/operators';
import { Product } from '../models/product.interface';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styles: [
  ]
})
export class ProductEditComponent implements OnInit {

  constructor(private route: ActivatedRoute,
              private router: Router,
              private productSvc: ProductService,
              private fb: FormBuilder) { }
  productForm: FormGroup;
  product$: Observable<Product>;
  productId$: Observable<string>;
  files: File[];

  ngOnInit(): void {
    this.productId$ = this.route.params.pipe(
      map(p => p.productId)
    );

    this.product$ = this.productId$.pipe(
      switchMap(p => this.productSvc.get(p))
    );

    this.productForm = this.fb.group({
      productId: [''],
      name: [''],
      price: ['']
    });

    // Is this right? Seems like I should be able to feed the form an observable
    this.product$.subscribe(val => {
      console.log(val);
      this.productForm.patchValue({
        ...val
      });
    });
  }

  submit() {
    this.productSvc.put(this.productForm.value).subscribe(() => {
      this.router.navigate(['products']);
    }, (err) => {
      alert(err);
      console.error(err);
    });
  }

  delete() {
    this.productSvc.delete(this.productForm.value).subscribe(() => {
      this.router.navigate(['products']);
    }, (err) => {
      alert(err);
      console.error(err);
    });
  }

  cancel() {
    this.router.navigate(['products']);
  }

  onSelect(event: { addedFiles: any; }) {
    console.log(event);
    this.files.push(...event.addedFiles);
  }

  onRemove(event: File) {
    console.log(event);
    this.files.splice(this.files.indexOf(event), 1);
  }

}
