import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/admin/adminproducts/products';

import { CustomerService } from 'src/app/Services/customer.service';
import { Cart } from 'src/app/TS/cart';

@Component({
   selector: 'app-searchpage',
   templateUrl: './searchpage.component.html',
   styleUrls: ['./searchpage.component.css'],
})
export class SearchpageComponent implements OnInit {
   constructor(private http: HttpClient, private router: Router, private CustomerService: CustomerService) {}

   ngOnInit(): void {}
   ProductList: Product[] = [];
   message: String;

   Product: Product = new Product();

   loginid = JSON.parse(sessionStorage.getItem('currentAdminId'));
   cart: Cart = new Cart();

   name: string = sessionStorage.getItem('currentAdminName');

   gotohome() {
      this.router.navigate(['/home']), sessionStorage.clear();
      alert('GOODBYE ' + this.name + ' HAVE A NICE DAY');
   }

   search(pname) {
      this.CustomerService.search(pname).subscribe((data) => {
         this.ProductList = data;
         if (this.ProductList[0] == null) this.message = 'Product not found :( ';
         else this.message = null;
         console.log(this.ProductList);
      });
   }

   addtomycart(productid: number, productname: string, productprice: number, producttype: string) {
      this.cart = {
         lid: this.loginid,
         pid: productid,
         id: 0,
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
