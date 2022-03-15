import { CUSTOM_ELEMENTS_SCHEMA, NgModule, NO_ERRORS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { CustomercartComponent } from './customer/customercart/customercart.component';
import { PaymentComponent } from './customer/payment/payment.component';
import { CategoryComponent } from './customer/category/category.component';
import { AboutComponent } from './about/about.component';
import { CustomerdashboardComponent } from './customer/customerdashboard/customerdashboard.component';
import { CustomerloginComponent } from './customer/customerlogin/customerlogin.component';
import { CustomerproductsComponent } from './customer/customerproducts/customerproducts.component';
import { CustomerprofileupdateComponent } from './customer/customerprofileupdate/customerprofileupdate.component';
import { CustomerregistrationComponent } from './customer/customerregistration/customerregistration.component';
import { PaymentsuccessComponent } from './customer/paymentsuccess/paymentsuccess.component';
import { SearchpageComponent } from './customer/searchpage/searchpage.component';
import { AdmineditproductComponent } from './admin/admineditproduct/admineditproduct.component';
import { AdminhomeComponent } from './admin/adminhome/adminhome.component';
import { AdminloginComponent } from './admin/adminlogin/adminlogin.component';
import { AdminproductsComponent } from './admin/adminproducts/adminproducts.component';
import { AdminviewcustomersComponent } from './admin/adminviewcustomers/adminviewcustomers.component';
import { AdminaddproductsComponent } from './admin/adminaddproducts/adminaddproducts.component';
import { ContactComponent } from './home/contact/contact.component';

@NgModule({
   declarations: [
      AppComponent,
      AdminloginComponent,
      CustomerregistrationComponent,
      HomeComponent,
      AdminhomeComponent,
      AdminproductsComponent,
      AdminaddproductsComponent,
      AdminviewcustomersComponent,
      AdmineditproductComponent,
      CustomerloginComponent,
      CustomerdashboardComponent,
      CustomerproductsComponent,
      CustomercartComponent,
      CustomerprofileupdateComponent,
      PaymentComponent,
      PaymentsuccessComponent,
      SearchpageComponent,
      CategoryComponent,
      AboutComponent,
      ContactComponent,
   ],
   imports: [BrowserModule, AppRoutingModule, FormsModule, HttpClientModule, BrowserAnimationsModule, MatSlideToggleModule],
   providers: [],
   bootstrap: [AppComponent],
   schemas: [CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA],
})
export class AppModule {}
