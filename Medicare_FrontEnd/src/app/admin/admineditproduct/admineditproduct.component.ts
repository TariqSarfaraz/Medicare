import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/Services/admin.service';
import { Product } from '../adminproducts/products';

@Component({
   selector: 'app-admineditproduct',
   templateUrl: './admineditproduct.component.html',
   styleUrls: ['./admineditproduct.component.css'],
})
export class AdmineditproductComponent implements OnInit {
   constructor(private http: HttpClient, private router: Router, private adminService: AdminService) {}

   @Input() msgFromParent1: any[];

   pid: number = parseInt(sessionStorage.getItem('pid'));

   ngOnInit(): void {}

   Product: Product = new Product();

   onclick() {
      this.adminService.editProduct(this.pid, this.Product).subscribe((data) => console.log(data));

      this.Product = new Product();

      this.router.navigate(['/adminproducts']);
   }

   gotohome() {
      this.router.navigate(['/home']), sessionStorage.clear();
   }

   adminhome() {
      this.router.navigate(['/adminhome']);
   }
}
