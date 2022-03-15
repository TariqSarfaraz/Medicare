import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from '../adminproducts/products';
import { AdminService } from '../../Services/admin.service';

@Component({
   selector: 'app-adminaddproducts',
   templateUrl: './adminaddproducts.component.html',
   styleUrls: ['./adminaddproducts.component.css'],
})
export class AdminaddproductsComponent implements OnInit {
   constructor(private http: HttpClient, private router: Router, private adminService: AdminService) {}

   ngOnInit(): void {}

   Product: Product = new Product();

   onclick() {
      this.adminService.addProduct(this.Product).subscribe((data) => console.log(data));
      this.Product = new Product();
      this.router.navigate(['/adminproducts']);
   }

   adminhome() {
      this.router.navigate(['/adminhome']);
   }

   gotohome() {
      alert('LOGOUT SUCCESSFUL');
      this.router.navigate(['/home']), sessionStorage.clear();
   }
}
