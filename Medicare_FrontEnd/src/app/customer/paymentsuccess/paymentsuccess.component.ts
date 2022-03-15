import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/admin/adminproducts/products';

import { CustomerService } from 'src/app/Services/customer.service';
import { Sum } from 'src/app/TS/sum';

@Component({
   selector: 'app-paymentsuccess',
   templateUrl: './paymentsuccess.component.html',
   styleUrls: ['./paymentsuccess.component.css'],
})
export class PaymentsuccessComponent implements OnInit {
   constructor(private http: HttpClient, private router: Router, private CustomerService: CustomerService) {}

   ngOnInit(): void {
      this.loadData(), this.sumofproduct();
   }
   name: string = sessionStorage.getItem('currentAdminName');

   ProductList: Product[] = [];

   sumList: Sum[] = [];

   loginid = JSON.parse(sessionStorage.getItem('currentAdminId'));

   sum: Sum[] = JSON.parse(sessionStorage.getItem('Sum'));

   product: Product[] = JSON.parse(sessionStorage.getItem('product'));

   loadData() {
      console.log('LOGIN ID' + this.loginid);
      this.CustomerService.bookedProducts(this.loginid).subscribe((data) => {
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

   backtodashboard() {
      this.router.navigate(['/customerproducts']);
      this.CustomerService.fornotprint(this.loginid).subscribe((data) => {
         console.log(this.loginid);
      });
   }
   printPage() {
      window.print();
      this.CustomerService.fornotprint(this.loginid).subscribe((data) => {
         console.log(this.loginid);
      });
   }

   gotohome() {
      this.router.navigate(['/home']), sessionStorage.clear();
      alert('GOODBYE ' + this.name + ' HAVE A NICE DAY');
   }
}
