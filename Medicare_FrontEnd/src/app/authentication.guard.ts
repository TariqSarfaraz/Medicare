import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
   providedIn: 'root',
})
export class AuthenticationGuard implements CanActivate {
   constructor(private router: Router) {}

   canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      if (sessionStorage.getItem('currentAdminId')) {
         return true;
      }

      this.router.navigate(['/home'], { queryParams: { returnurl: state.url } });
      return false;
   }
}
