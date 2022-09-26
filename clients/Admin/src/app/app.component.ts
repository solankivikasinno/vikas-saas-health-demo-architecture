/*
infrateam and application team
 */
import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import {
  OidcSecurityService,
  PublicEventsService,
  EventTypes,
} from 'angular-auth-oidc-client';
import { tap, filter } from 'rxjs/operators';

@Component({
  // tslint:disable-next-line
  selector: 'body',
  template: '<router-outlet></router-outlet>'
})
export class AppComponent implements OnInit {
  constructor(
    private router: Router,
    public oidcSecurityService: OidcSecurityService,
    private eventService: PublicEventsService
  ) {}

  ngOnInit() {
    this.oidcSecurityService
      .checkAuth()
      .subscribe((isAuthenticated) =>
        console.log('app authenticated', isAuthenticated)
      );

    this.eventService
      .registerForEvents()
      .pipe(
        tap((x) => console.log('Notif:', x)),
        filter(
          (notification) =>
            notification.type === EventTypes.CheckSessionReceived
        )
      )
      .subscribe((value) =>
        console.log('CheckSessionReceived with value from app', value)
      );

    this.router.events.subscribe((evt) => {
      if (!(evt instanceof NavigationEnd)) {
        return;
      }
      window.scrollTo(0, 0);
    });
  }
}
