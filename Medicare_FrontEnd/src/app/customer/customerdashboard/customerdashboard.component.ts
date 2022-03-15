import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/Services/customer.service';
import { Cart } from 'src/app/TS/cart';

@Component({
   selector: 'app-customerdashboard',
   templateUrl: './customerdashboard.component.html',
   styleUrls: ['./customerdashboard.component.css'],
})
export class CustomerdashboardComponent implements OnInit {
   constructor(private http: HttpClient, private router: Router, private CustomerService: CustomerService) {}

   ngOnInit(): void {
      this.loadData();
   }

   id: number = parseInt(sessionStorage.getItem('currentAdminId'));
   name: string = sessionStorage.getItem('currentAdminName');

   ProductList: Cart[] = [];

   loadData() {
      this.CustomerService.bookedProducts(this.id).subscribe((data) => {
         this.ProductList = data;
         console.log(this.ProductList);
      });
   }

   onclick() {
      this.router.navigate(['/customerproducts']);
   }

   updateprofile() {
      this.router.navigate(['/customerprofileupdate']);
   }

   mycart() {
      this.router.navigate(['/customercart']);
   }

   search() {
      this.router.navigate(['/searchpage']);
   }

   CategoryComponent() {
      this.router.navigate(['/CategoryComponent']);
   }

   gotohome() {
      this.router.navigate(['/home']), sessionStorage.clear();
      alert('GOODBYE ' + this.name + ' HAVE A NICE DAY');
   }
}
