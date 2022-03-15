import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
   selector: 'app-root',
   templateUrl: './app.component.html',
   styleUrls: ['./app.component.css'],
})
export class AppComponent {
   title = 'Medipro';
   constructor(private router: Router) {}

   gotoregister() {
      this.router.navigate(['/register']);
   }

   signin() {
      this.router.navigate(['/login']);
   }

   adminhome() {
      this.router.navigate(['/adminhome']);
   }

   gotohome() {
      this.router.navigate(['/video']);
   }

   customerdashboard() {
      this.router.navigate(['/customerdashboard']);
   }

   csignin() {
      this.router.navigate(['/customerlogin']);
   }

   taketohome() {
      this.router.navigate(['']), sessionStorage.clear();
   }

   aboutus() {
      this.router.navigate(['/about']);
      sessionStorage.clear();
   }
   contact() {
      this.router.navigate(['/contact']);
      sessionStorage.clear();
   }
}
