import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { CustomerService } from '../../Services/customer.service';
import { Cart } from '../../TS/cart';
import { Sum } from '../../TS/sum';

@Component({
   selector: 'app-customercart',
   templateUrl: './customercart.component.html',
   styleUrls: ['./customercart.component.css'],
})
export class CustomercartComponent implements OnInit {
   constructor(private http: HttpClient, private router: Router, private CustomerService: CustomerService) {}

   ProductList: Cart[] = [];

   sumList: Sum[] = [];

   cart: Cart = new Cart();

   loginid = JSON.parse(sessionStorage.getItem('currentAdminId'));

   ngOnInit(): void {
      this.loadData(), this.sumofproduct();
   }
   backtodashboard() {
      this.router.navigate(['/customerdashboard']);
   }

   loadData() {
      console.log('LOGIN ID' + this.loginid);
      this.CustomerService.myproducts(this.loginid).subscribe((data) => {
         this.ProductList = data;
         console.log(this.ProductList);
      });
   }

   sumofproduct() {
      this.CustomerService.sumofproducts(this.loginid).subscribe((data) => {
         this.sumList = data;
         console.log(this.sumList);
      });
   }

   OnClickDelProdct(id: number) {
      this.CustomerService.OnClickDelProdct(id).subscribe((data) => {
         console.log(id);
      });
      window.location.reload();
      alert('Deletion Success');
   }

   payment() {
      this.router.navigate(['/payment']);
   }

   productquantity(id, prd_qty) {
      this.CustomerService.productquantity(this.loginid, id, prd_qty).subscribe((data) => {
         console.log(prd_qty);
      });
   }

   name: string = sessionStorage.getItem('currentAdminName');

   gotohome() {
      this.router.navigate(['/home']), sessionStorage.clear();
      alert('GOODBYE ' + this.name + ' HAVE A NICE DAY');
   }
}
