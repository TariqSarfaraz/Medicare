import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/admin/adminproducts/products';

import { CustomerService } from 'src/app/Services/customer.service';
import { Cart } from 'src/app/TS/cart';

@Component({
   selector: 'app-customerproducts',
   templateUrl: './customerproducts.component.html',
   styleUrls: ['./customerproducts.component.css'],
})
export class CustomerproductsComponent implements OnInit {
   constructor(private http: HttpClient, private router: Router, private CustomerService: CustomerService) {}

   ngOnInit(): void {
      this.loadData();
   }

   name: string = sessionStorage.getItem('currentAdminName');

   gotohome() {
      this.router.navigate(['/home']), sessionStorage.clear();
      alert('GOODBYE ' + this.name + ' HAVE A NICE DAY');
   }

   loginid = JSON.parse(sessionStorage.getItem('currentAdminId'));

   ProductList: Product[] = [];

   cart: Cart = new Cart();

   loadData() {
      this.CustomerService.listAllAvaProducts().subscribe((data) => {
         this.ProductList = data;
         console.log(this.ProductList);
      });
   }

   addtomycart(productid: number, productname: string, productprice: number, producttype: string) {
      this.cart = {
         id: 0,
         lid: this.loginid,
         pid: productid,
         booked: 'U',
         pname: productname,
         price: productprice,
         ptype: producttype,
      };

      this.CustomerService.addtomycart(this.cart).subscribe((data) => {
         console.log(this.cart);
         console.log(this.loginid);
         console.log(productid);
      });
      this.router.navigate(['/customercart']);
   }

   backtodashboard() {
      this.router.navigate(['/customerdashboard']);
   }
}
