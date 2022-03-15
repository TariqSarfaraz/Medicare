import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/Services/admin.service';

import { Customer } from './Customers';

@Component({
   selector: 'app-adminviewcustomers',
   templateUrl: './adminviewcustomers.component.html',
   styleUrls: ['./adminviewcustomers.component.css'],
})
export class AdminviewcustomersComponent implements OnInit {
   constructor(private http: HttpClient, private router: Router, private adminService: AdminService) {}

   CustomerList: Customer[] = [];

   ngOnInit(): void {
      this.loadData();
   }

   loadData() {
      this.adminService.listAllCustomers().subscribe((data) => {
         this.CustomerList = data;
         console.log(this.CustomerList);
      });
   }
   adminhome() {
      this.router.navigate(['/adminhome']);
   }
   gotohome() {
      alert('LOGOUT SUCCESSFUL');
      this.router.navigate(['/home']), sessionStorage.clear();
   }
}
