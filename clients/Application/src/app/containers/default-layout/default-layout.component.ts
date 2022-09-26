/*
infrateam and application team
 */
import {Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { OidcSecurityService } from 'angular-auth-oidc-client';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { AuthConfigurationService } from '../../views/auth/auth-configuration.service';
import { navItems } from '../../_nav';

@Component({
  selector: 'app-dashboard',
  templateUrl: './default-layout.component.html'
})
export class DefaultLayoutComponent implements OnInit {
  public sidebarMinimized = false;
  public navItems = navItems;
  isAuthenticated$: Observable<Boolean>;
  username$: Observable<string>;
  constructor(public oidcSecurityService: OidcSecurityService,
              private authService: AuthConfigurationService,
              private router: Router) {}



  ngOnInit() {
    this.isAuthenticated$ = this.oidcSecurityService.isAuthenticated$;
    this.username$ = this.oidcSecurityService.userData$.pipe(
      map(ud => ud['email'])
    );
  }

  login() {
    this.oidcSecurityService.authorize();
  }

  logout() {
    this.oidcSecurityService.logoffAndRevokeTokens().subscribe(() => {});
    this.authService.LogOutOfCognito().subscribe(() => {});
  }

  toggleMinimize(e) {
    this.sidebarMinimized = e;
  }
}
