import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
   selector: 'app-adminhome',
   templateUrl: './adminhome.component.html',
   styleUrls: ['./adminhome.component.css'],
})
export class AdminhomeComponent implements OnInit {
   constructor(private router: Router) {}

   ngOnInit(): void {}

   gotoadminproducts() {
      this.router.navigate(['/adminproducts']);
   }

   gotoaddproducts() {
      this.router.navigate(['/adminaddprodcuts']);
   }

   gotoadminviewcustomers() {
      this.router.navigate(['/adminviewcustomers']);
   }

   gotohome() {
      alert('LOGOUT SUCCESSFUL');
      this.router.navigate(['/home']), sessionStorage.clear();
   }
}
