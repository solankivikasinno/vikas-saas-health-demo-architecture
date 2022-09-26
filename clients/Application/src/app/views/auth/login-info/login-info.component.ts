/*
infrateam and application team
 */
import { Component, OnInit } from '@angular/core';
import { OidcClientNotification, OidcSecurityService, PublicConfiguration } from 'angular-auth-oidc-client';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-login-info',
  templateUrl: './login-info.component.html',
  styleUrls: ['login-info.component.scss']
})
export class LoginInfoComponent implements OnInit {
  configuration: PublicConfiguration;
  userDataChanged$: Observable<OidcClientNotification<any>>;
  userData$: Observable<any>;
  isAuthenticated$: Observable<boolean>;
  checkSessionChanged$: Observable<boolean>;
  checkSessionChanged: any;
  idToken: any;
  accessToken: any;

  constructor(public oidcSecurityService: OidcSecurityService) {}

  ngOnInit() {
      this.configuration = this.oidcSecurityService.configuration;
      this.userData$ = this.oidcSecurityService.userData$;
      this.isAuthenticated$ = this.oidcSecurityService.isAuthenticated$;
      this.checkSessionChanged$ = this.oidcSecurityService.checkSessionChanged$;
      this.idToken = this.oidcSecurityService.getIdToken()?.trim();
      this.accessToken = this.oidcSecurityService.getToken()?.trim();
    }

  login() {
      this.oidcSecurityService.authorize();
  }

  forceRefreshSession() {
      this.oidcSecurityService.forceRefreshSession().subscribe((result) => console.warn(result));
  }
  logout() {
      this.oidcSecurityService.logoff();
  }
}
