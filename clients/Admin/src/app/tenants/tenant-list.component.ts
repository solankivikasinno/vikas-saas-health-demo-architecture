/*
infrateam and application team
 */
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Tenant } from './models/tenant';
import { TenantService } from './tenant.service';

@Component({
  selector: 'app-tenant-list',
  templateUrl: './tenant-list.component.html',
  styles: [
  ]
})
export class TenantListComponent implements OnInit {

  constructor(private tenantSvc: TenantService) { }
  tenants: Observable<any[]>;

  ngOnInit(): void {
    this.tenants = this.tenantSvc.getTenants();
  }
}

