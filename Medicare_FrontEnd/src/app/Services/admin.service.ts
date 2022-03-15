import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../admin/adminproducts/products';
import { Adminlogin } from '../adminlogin';

import { Admin } from '../TS/admin';

@Injectable({
   providedIn: 'root',
})
export class AdminService {
   constructor(private http: HttpClient) {}

   baseurl = 'http://localhost:8686/products';

   baseurl1 = 'http://localhost:8686/login';

   editProduct(id: number, product: Product) {
      console.log(id);
      console.log(product);
      return this.http.post<any[]>(this.baseurl + '/editProducts/' + id, product);
   }

   listAllProducts() {
      return this.http.get<any[]>(this.baseurl + '/productlists');
   }

   delete(id: number) {
      return this.http.delete<any[]>(this.baseurl + '/delProducts/' + id);
   }

   addProduct(product: Product) {
      return this.http.post<any[]>(this.baseurl + '/addProducts', product);
   }

   update(id: number) {
      return this.http.post<any[]>(this.baseurl + '/toggleProducts/' + id, Product);
   }

   updateSecond(id: number) {
      return this.http.post<any[]>(this.baseurl + '/toggleProductSeconds/' + id, Product);
   }

   listAllCustomers() {
      return this.http.get<any[]>(this.baseurl1 + '/getUsers');
   }

   adminLogin(adminLogin: Adminlogin): Observable<Admin> {
      return this.http.post<Admin>('http://localhost:8686/login/loginAdmin', adminLogin);
   }
}
