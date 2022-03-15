import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Adminlogin } from 'src/app/adminlogin';
import { AdminService } from 'src/app/Services/admin.service';

@Component({
   selector: 'app-customerlogin',
   templateUrl: './customerlogin.component.html',
   styleUrls: ['./customerlogin.component.css'],
})
export class CustomerloginComponent implements OnInit {
   currentMsgToChild1 = '';

   message: string;

   adminLogin: Adminlogin = new Adminlogin();

   constructor(private adminService: AdminService, private router: Router) {}

   ngOnInit(): void {}

   login() {
      console.log(JSON.stringify(this.adminLogin));
      this.adminService.adminLogin(this.adminLogin).subscribe((adminStatus) => {
         // alert(JSON.stringify(adminStatus));
         if (adminStatus != null) {
            this.message = '';
            sessionStorage.setItem('currentAdminId', adminStatus.id.toString());
            sessionStorage.setItem('currentAdminName', adminStatus.name);
            sessionStorage.setItem('currentPass', adminStatus.password);
            sessionStorage.setItem('currentContact', adminStatus.contact.toString());
            localStorage.setItem('currentAdminId', adminStatus.id.toString());
            //  this.router.navigate(['/adminViews']);
            this.message = 'Login successful';

            this.router.navigate(['/customerdashboard']);
         } else {
            this.message = 'Invalid Credentials';
         }
      });
   }
}
