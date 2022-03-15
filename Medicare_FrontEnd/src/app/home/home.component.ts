import { Component, OnInit } from '@angular/core';
import { Router, RouterModule } from '@angular/router';

@Component({
   selector: 'app-home',
   templateUrl: './home.component.html',
   styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
   constructor(private router: Router) {}

   ngOnInit(): void {}

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
}
