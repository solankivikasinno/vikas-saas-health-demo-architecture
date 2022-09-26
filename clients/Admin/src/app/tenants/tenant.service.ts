/*
infrateam and application team
 */

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { Tenant } from './models/tenant';

@Injectable({
  providedIn: 'root'
})
export class TenantService {
  constructor(private http: HttpClient) { }

  apiUrl = `${environment.apiUrl}/tenants`;

  // TODO strongly-type these anys as tenants once we dial in what the tenant call should return
  getTenants(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }
}
