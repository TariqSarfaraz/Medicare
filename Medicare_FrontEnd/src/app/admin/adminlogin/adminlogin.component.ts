import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Adminlogin } from 'src/app/adminlogin';
import { AdminService } from 'src/app/Services/admin.service';

@Component({
   selector: 'app-adminlogin',
   templateUrl: './adminlogin.component.html',
   styleUrls: ['./adminlogin.component.css'],
})
export class AdminloginComponent implements OnInit {
   message: string;

   adminLogin: Adminlogin = new Adminlogin();

   constructor(private adminService: AdminService, private router: Router) {}

   ngOnInit(): void {}

   login() {
      if (this.adminLogin.id == 'Admin' && this.adminLogin.password == 'Admin') {
         sessionStorage.setItem('currentAdminId', this.adminLogin.id.toString());
         this.router.navigate(['/adminhome']);
      } else alert('Incorrect Details');
   }

   gotohome() {
      alert('LOGOUT SUCCESSFUL');
      this.router.navigate(['/home']), sessionStorage.clear();
   }
}
