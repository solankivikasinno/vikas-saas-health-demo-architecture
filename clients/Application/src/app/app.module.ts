/*
infrateam and application team
 */
import { BrowserModule } from '@angular/platform-browser';
import { NgModule, APP_INITIALIZER } from '@angular/core';
import { LocationStrategy, HashLocationStrategy } from '@angular/common';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { OidcConfigService, AuthModule } from 'angular-auth-oidc-client';
import { PerfectScrollbarModule } from 'ngx-perfect-scrollbar';
import { PerfectScrollbarConfigInterface } from 'ngx-perfect-scrollbar';
// RECOMMENDED
import { CarouselModule } from 'ngx-bootstrap/carousel';

const DEFAULT_PERFECT_SCROLLBAR_CONFIG: PerfectScrollbarConfigInterface = {
  suppressScrollX: true
};

import { AppComponent } from './app.component';

// Import containers
import { DefaultLayoutComponent } from './containers';

import { P404Component } from './views/error/404.component';
import { P500Component } from './views/error/500.component';
import { LogoffComponent } from './views/logoff/logoff.component';

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
import { AlertModule } from 'ngx-bootstrap/alert';
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { TabsModule } from 'ngx-bootstrap/tabs';
import { ChartsModule } from 'ng2-charts';
import { HttpClient } from '@angular/common/http';
import { configureAuth } from './views/auth/auth-config';
import { UnauthorizedComponent } from './views/error/unauthorized.component';
import { httpInterceptorProviders } from './interceptors';
import { CollapseModule } from 'ngx-bootstrap/collapse';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AuthConfigurationService } from './views/auth/auth-configuration.service';

@NgModule({
  imports: [
    AlertModule,
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
    CarouselModule.forRoot(),
    ChartsModule,
    CollapseModule.forRoot(),
    FormsModule,
    PerfectScrollbarModule,
    ReactiveFormsModule,
    TabsModule.forRoot(),
  ],
  declarations: [
    ...APP_CONTAINERS,
    AppComponent,
    LogoffComponent,
    P404Component,
    P500Component,
    UnauthorizedComponent,
  ],
  providers: [
    HttpClient,
    {
      provide: LocationStrategy,
      useClass: HashLocationStrategy,
    },
    OidcConfigService,
    {
        provide: APP_INITIALIZER,
        useFactory: configureAuth,
        deps: [AuthConfigurationService],
        multi: true,
    },
    httpInterceptorProviders,
  ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
