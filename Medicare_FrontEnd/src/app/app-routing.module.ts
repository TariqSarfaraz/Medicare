import { HtmlParser } from '@angular/compiler';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { AdminaddproductsComponent } from './admin/adminaddproducts/adminaddproducts.component';
import { AdmineditproductComponent } from './admin/admineditproduct/admineditproduct.component';
import { AdminhomeComponent } from './admin/adminhome/adminhome.component';
import { AdminloginComponent } from './admin/adminlogin/adminlogin.component';
import { AdminproductsComponent } from './admin/adminproducts/adminproducts.component';
import { AdminviewcustomersComponent } from './admin/adminviewcustomers/adminviewcustomers.component';
import { AppComponent } from './app.component';
import { AuthenticationGuard } from './authentication.guard';
import { CategoryComponent } from './customer/category/category.component';
import { CustomercartComponent } from './customer/customercart/customercart.component';
import { CustomerdashboardComponent } from './customer/customerdashboard/customerdashboard.component';
import { CustomerloginComponent } from './customer/customerlogin/customerlogin.component';
import { CustomerproductsComponent } from './customer/customerproducts/customerproducts.component';
import { CustomerprofileupdateComponent } from './customer/customerprofileupdate/customerprofileupdate.component';
import { CustomerregistrationComponent } from './customer/customerregistration/customerregistration.component';
import { PaymentComponent } from './customer/payment/payment.component';
import { PaymentsuccessComponent } from './customer/paymentsuccess/paymentsuccess.component';
import { SearchpageComponent } from './customer/searchpage/searchpage.component';
import { ContactComponent } from './home/contact/contact.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
   { path: '', component: HomeComponent },
   { path: 'register', component: CustomerregistrationComponent },
   { path: 'login', component: AdminloginComponent },
   { path: 'adminaddprodcuts', component: AdminaddproductsComponent, canActivate: [AuthenticationGuard] },
   { path: 'adminproducts', component: AdminproductsComponent, canActivate: [AuthenticationGuard] },
   { path: 'adminviewcustomers', canActivate: [AuthenticationGuard], component: AdminviewcustomersComponent },
   { path: 'adminhome', component: AdminhomeComponent, canActivate: [AuthenticationGuard] },
   { path: 'admineditproduct', component: AdmineditproductComponent, canActivate: [AuthenticationGuard] },
   { path: 'home', component: HomeComponent },
   { path: 'apphome', component: AppComponent, canActivate: [AuthenticationGuard] },
   { path: 'customerdashboard', component: CustomerdashboardComponent, canActivate: [AuthenticationGuard] },
   { path: 'customerlogin', component: CustomerloginComponent, canActivate: [AuthenticationGuard] },
   { path: 'customerproducts', component: CustomerproductsComponent, canActivate: [AuthenticationGuard] },
   { path: 'customerprofileupdate', component: CustomerprofileupdateComponent, canActivate: [AuthenticationGuard] },
   { path: 'customercart', component: CustomercartComponent, canActivate: [AuthenticationGuard] },
   { path: 'payment', component: PaymentComponent, canActivate: [AuthenticationGuard] },
   { path: 'paymentsuccess', component: PaymentsuccessComponent, canActivate: [AuthenticationGuard] },
   { path: 'searchpage', component: SearchpageComponent, canActivate: [AuthenticationGuard] },
   { path: 'CategoryComponent', component: CategoryComponent, canActivate: [AuthenticationGuard] },
   { path: 'about', component: AboutComponent },
   { path: 'contact', component: ContactComponent },
];

@NgModule({
   imports: [RouterModule.forRoot(routes)],
   exports: [RouterModule],
   providers: [AuthenticationGuard],
})
export class AppRoutingModule {}
