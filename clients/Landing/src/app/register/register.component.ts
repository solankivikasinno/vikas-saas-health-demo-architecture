/*
infrateam and application team
 */
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { environment } from 'src/environments/environment';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html'
})
export class RegisterComponent implements OnInit {
  form: FormGroup;
  submitting = false;
  error = false;
  success = false;

  constructor(private fb: FormBuilder,
              private http: HttpClient) { }

  ngOnInit(): void {
    this.form = this.fb.group({
      name: [null, [Validators.required]],
      email: [null, [Validators.email, Validators.required]],
      companyName: [null, [Validators.required]],
      plan: [null, [Validators.required]],
    });
  }

  onSubmit() {
    const API_URL = `${environment.apiUrl}/register`;
    const domain = environment.domain;

    const user = {
      ...this.form.value,
      customDomain: domain
    };

    this.submitting = true;
    this.http.post(API_URL, user)
    .subscribe(
      val => {
        this.submitting = false;
        this.success = true;
        this.error = false;
      },
      err => {
        this.submitting = false;
        this.success = false;
        this.error = true;
        console.log(err);
      }
    );
  }

  isFieldInvalid(field: string) {
    const formField = this.form.get(field);
    return formField.invalid && (formField.dirty || formField.touched);
  }

  displayFieldCss(field: string) {
    return {
      'is-invalid': this.isFieldInvalid(field),
    };
  }

  hasRequiredError(field: string) {
    return this.hasError(field, 'required');
  }

  hasError(field: string, error: any) {
    const formField = this.form.get(field);
    return !!formField.errors[error];
  }

  getTenantUrl() {
    const host: string[] = window.location.hostname.split('.');
    const companyName: string = this.form.value.companyName;
    const re = /[\W\s]+/g;
    const tenantId = companyName.replace(re, '').toLowerCase();
    const url = `https://${tenantId}.${host.length === 1 ? 'eks-ref-arch.com' : host.slice(1, 2)}`;
    return url;
  }
}
