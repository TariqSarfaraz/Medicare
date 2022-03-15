import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/Services/admin.service';
import { Product } from './products';

@Component({
   selector: 'app-adminproducts',
   templateUrl: './adminproducts.component.html',
   styleUrls: ['./adminproducts.component.css'],
})
export class AdminproductsComponent implements OnInit {
   constructor(private http: HttpClient, private router: Router, private adminService: AdminService) {}

   msg: string;
   flag: boolean;
   currentMsgToChild1 = '';
   pid: number;
   status: string;

   ngOnInit(): void {
      this.viewdata();
   }

   adminhome() {
      this.router.navigate(['/adminhome']);
   }

   show: boolean;

   ProductList: Product[] = [];

   viewdata() {
      this.adminService.listAllProducts().subscribe((data) => {
         this.ProductList = data;
         console.log(this.ProductList);
      });
   }

   OnClickEdit(pid: number) {
      this.router.navigate(['/admineditproduct']);
      sessionStorage.setItem('pid', JSON.stringify(pid));
   }

   OnClickDel(pid: number) {
      this.adminService.delete(pid).subscribe((data) => {
         console.log(data);
      }),
         window.location.reload();
      alert('DELETION SUCCESS');
   }

   available(pid: number) {
      this.router.navigate(['/adminhome']);
      this.adminService.update(pid).subscribe((data) => {
         console.log(data);
      });
   }

   testing(pid: number, status: string): void {
      if (status == 'N') {
         this.adminService.update(pid).subscribe((data) => {
            console.log(data);
            console.log(this.msg);
         }),
            window.location.reload();
      } else {
         this.adminService.updateSecond(pid).subscribe((data) => {
            console.log(data);
         }),
            window.location.reload();
      }
   }

   gotohome() {
      alert('LOGOUT SUCCESSFUL');
      this.router.navigate(['/home']), sessionStorage.clear();
   }
}
