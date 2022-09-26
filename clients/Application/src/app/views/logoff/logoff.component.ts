/*
infrateam and application team
 */
import { Component, OnInit } from '@angular/core';
import { OidcSecurityService } from 'angular-auth-oidc-client';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-logoff',
  templateUrl: './logoff.component.html',
  styles: [
  ]
})
export class LogoffComponent implements OnInit {

  constructor(private securityService: OidcSecurityService,) { }

  ngOnInit(): void {
  }

  login() {
    this.securityService.authorize();
  }

}
