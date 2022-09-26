/*
infrateam and application team
 */
import { Injectable } from '@angular/core';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class ServiceHelperService {
  constructor() {}

  getUrl(entity: string) {
    const tenantId = this.getTenantName();
    const url = `${environment.apiUrl}/${tenantId}/${entity}/api`;
    return url;
  }

  getTenantName() {
    const hostname = window.location.hostname;
    const parts = hostname.split('.');
    const tenantId = parts.length === 1 ? 'saascoffee' : parts[0];
    return tenantId;
  }
}
