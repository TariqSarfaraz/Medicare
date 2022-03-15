import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../admin/adminproducts/products';

import { Cart } from '../TS/cart';

import { Customer } from '../TS/customer';

@Injectable({
   providedIn: 'root',
})
export class CustomerService {
   constructor(private http: HttpClient) {}

   baseurl = 'http://localhost:8686/products';
   baseurlcarts = 'http://localhost:8686/carts';

   //to delete product from cart
   OnClickDelProdct(id: number) {
      return this.http.delete<any[]>(this.baseurlcarts + '/delProductfromCarts/' + id);
   }

   //to update productquantity
   //http://localhost:8686/cart/updateaddone/{pid}/{lid}/{prd_qty}
   productquantity(lid: number, pid: number, prd_qty: number) {
      return this.http.post<any[]>('http://localhost:8686/carts/updateaddone/' + pid + '/' + lid + '/' + prd_qty, Cart);
   }

   //to make products as booked
   booked(id: number) {
      return this.http.put<any[]>(this.baseurlcarts + '/makebooking/' + id, Cart);
   }

   //to get booked products
   bookedProducts(id: number) {
      return this.http.get<any[]>(this.baseurlcarts + '/bookedProducts/' + id);
   }

   //to make customer regsitration
   register(customer: Customer): Observable<any> {
      return this.http.post<Customer>('http://localhost:8686/login/addlogin', customer);
   }

   id: number = parseInt(sessionStorage.getItem('currentAdminId'));

   //to make customer password
   UpdateProfile(customer: Customer): Observable<any> {
      return this.http.put<Customer>('http://localhost:8686/login/UpdateName/' + this.id, customer);
   }
   //to get list of available products
   listAllAvaProducts() {
      return this.http.get<any[]>(this.baseurl + '/productavalists');
   }

   //to add carts to products
   addtomycart(cart: Cart) {
      console.log(cart);
      return this.http.post<any[]>('http://localhost:8686/carts/addToCarts', cart);
   }

   //to get products as per login id
   myproducts(id: number) {
      console.log(id);
      return this.http.get<any[]>('http://localhost:8686/carts/cartlistsbyloginsid/' + id);
   }

   //to get sum of products
   sumofproducts(id: number) {
      return this.http.get<any[]>(this.baseurlcarts + '/sumofproducts/' + id);
   }

   //to make print as p
   forprint(id: number) {
      return this.http.put<any[]>(this.baseurlcarts + '/forprint/' + id, Cart);
   }

   //not to make print as p
   fornotprint(id: number) {
      return this.http.put<any[]>(this.baseurlcarts + '/fornotprint/' + id, Cart);
   }

   //search by product name
   search(pname: string) {
      return this.http.put<any[]>(this.baseurlcarts + '/search/' + pname, Product);
   }

   //categories
   //antibiotic category

   antibiotic() {
      return this.http.get<any[]>('http://localhost:8686/products/Antibiotics');
   }

   SYRUP() {
      return this.http.get<any[]>('http://localhost:8686/products/SYRUPS');
   }

   INSULIN() {
      return this.http.get<any[]>('http://localhost:8686/products/INSULINS');
   }
}
