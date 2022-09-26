/*
infrateam and application team
 */
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { OidcSecurityService } from 'angular-auth-oidc-client';
import { Observable, of } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({ providedIn: 'root' })
export class CognitoGuard implements CanActivate {
    constructor(private oidcSecurityService: OidcSecurityService, private router: Router) {}

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> {

      function getResolvedUrl(route: ActivatedRouteSnapshot): string {
        return route.pathFromRoot
            .map(v => v.url.map(segment => segment.toString()).join(''))
            .join('/');
      }
      return this.oidcSecurityService.isAuthenticated$.pipe(
          map((isAuthorized: boolean) => {
              console.log('AuthorizationGuard, canActivate isAuthorized: ' + isAuthorized);
              if (!isAuthorized) {
                  this.router.navigate(['/unauthorized']);
                  return false;
              }

              return true;
          })
      );
    }
}
