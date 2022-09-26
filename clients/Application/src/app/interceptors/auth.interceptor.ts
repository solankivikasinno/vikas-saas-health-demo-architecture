/*
infrateam and application team
 */
import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { OidcSecurityService } from 'angular-auth-oidc-client';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  constructor(private oidcSecurityService: OidcSecurityService) {}

  intercept(
    req: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    const token = this.oidcSecurityService.getIdToken();

    // We only want to add the ID Token to our API endpoints. Let the Auth library handle
    // tokens for the Cognito endpoints
    if (!token || req.url.includes('amazoncognito')) {
      return next.handle(req);
    }

    req = req.clone({
      headers: req.headers.set('Authorization', 'Bearer ' + token),
    });

    return next.handle(req);
  }
}
