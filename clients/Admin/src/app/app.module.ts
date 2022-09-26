/*
infrateam and application team
 */
import { BrowserModule } from '@angular/platform-browser';
import { APP_INITIALIZER, NgModule } from '@angular/core';
import { LocationStrategy, HashLocationStrategy } from '@angular/common';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { filter } from 'rxjs/operators';
import { PerfectScrollbarModule } from 'ngx-perfect-scrollbar';
import { PerfectScrollbarConfigInterface } from 'ngx-perfect-scrollbar';
import { AuthModule, EventTypes, LogLevel, OidcConfigService, PublicEventsService } from 'angular-auth-oidc-client';

const DEFAULT_PERFECT_SCROLLBAR_CONFIG: PerfectScrollbarConfigInterface = {
  suppressScrollX: true
};

import { AppComponent } from './app.component';

// Import containers
import { DefaultLayoutComponent } from './containers';

import { P404Component } from './views/error/404.component';
import { P500Component } from './views/error/500.component';

const APP_CONTAINERS = [
  DefaultLayoutComponent
];

import {
  AppAsideModule,
  AppBreadcrumbModule,
  AppHeaderModule,
  AppFooterModule,
  AppSidebarModule,
} from '@coreui/angular';

// Import routing module
import { AppRoutingModule } from './app.routing';

// Import 3rd party components
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { TabsModule } from 'ngx-bootstrap/tabs';
import { ChartsModule } from 'ng2-charts';
import { HttpClientModule } from '@angular/common/http';
import { configureAuth } from './views/auth/configure-auth';
import { UnauthorizedComponent } from './views/error/unauthorized.component';
import { httpInterceptorProviders } from './interceptors';

@NgModule({
  imports: [
    AppAsideModule,
    AppBreadcrumbModule.forRoot(),
    AppFooterModule,
    AppHeaderModule,
    AppRoutingModule,
    AppSidebarModule,
    AuthModule.forRoot(),
    BrowserAnimationsModule,
    BrowserModule,
    BsDropdownModule.forRoot(),
    ChartsModule,
    HttpClientModule,
    PerfectScrollbarModule,
    TabsModule.forRoot(),
  ],
  declarations: [
    AppComponent,
    ...APP_CONTAINERS,
    P404Component,
    P500Component,
    UnauthorizedComponent,
  ],
  providers: [
    OidcConfigService,
    {
        provide: APP_INITIALIZER,
        useFactory: configureAuth,
        deps: [OidcConfigService],
        multi: true,
    },
    {
      provide: LocationStrategy,
      useClass: HashLocationStrategy,
    },
    HttpClientModule,
    httpInterceptorProviders,
  ],
  bootstrap: [ AppComponent ]
})
export class AppModule {
  constructor(private readonly eventService: PublicEventsService) {
    this.eventService
        .registerForEvents()
        .pipe(filter((notification) => notification.type === EventTypes.ConfigLoaded))
        .subscribe((config) => {
            console.log('ConfigLoaded', config);
        });
  }
}
