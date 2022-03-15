import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/admin/adminproducts/products';
import { CustomerService } from '../../Services/customer.service';
import { Sum } from '../../TS/sum';

@Component({
   selector: 'app-payment',
   templateUrl: './payment.component.html',
   styleUrls: ['./payment.component.css'],
})
export class PaymentComponent implements OnInit {
   constructor(private http: HttpClient, private router: Router, private CustomerService: CustomerService) {}

   ngOnInit(): void {
      this.loadData(), this.sumofproduct();
   }

   name: string = sessionStorage.getItem('currentAdminName');

   gotohome() {
      this.router.navigate(['/home']), sessionStorage.clear();
      alert('GOODBYE ' + this.name + ' HAVE A NICE DAY');
   }
   Product: Product = new Product();

   ProductList: Product[] = [];

   sum: Sum = new Sum();

   sumList: Sum[] = [];

   loginid = JSON.parse(sessionStorage.getItem('currentAdminId'));

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
         sessionStorage.setItem('Sum', JSON.stringify(this.sumList));
         console.log(this.sumList);
      });
   }

   backtoproducts() {
      this.router.navigate(['/customerproducts']);
   }

   paymentsuccess(ProductList: Product) {
      this.CustomerService.booked(this.loginid).subscribe((data) => {
         this.ProductList = data;
         console.log(this.loginid);
      }),
         sessionStorage.setItem('product', JSON.stringify(this.ProductList));
      this.CustomerService.forprint(this.loginid).subscribe((data) => {
         console.log(this.loginid);
      });

      this.router.navigate(['/paymentsuccess']);
   }

   backtodashboard() {
      this.router.navigate(['/customerdashboard']);
   }
}
