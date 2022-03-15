import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/Services/customer.service';
import { Customer } from 'src/app/TS/customer';
import { AbstractControl, ValidationErrors, ValidatorFn } from '@angular/forms';

@Component({
   selector: 'app-customerregistration',
   templateUrl: './customerregistration.component.html',
   styleUrls: ['./customerregistration.component.css'],
})
export class CustomerregistrationComponent implements OnInit {
   message: string;
   car: Customer = new Customer();

   constructor(private customerService: CustomerService, private router: Router) {}

   ngOnInit(): void {}

   register() {
      console.log(JSON.stringify(this.car));
      this.customerService.register(this.car).subscribe((data) => {
         if (data != null) {
            alert('Registraion Successful, Your Login ID is ' + data);
            this.router.navigate(['']);
         } else {
            this.message = 'Registration Failed.';
         }
      });
   }
   createPasswordStrengthValidator(): ValidatorFn {
      return (control: AbstractControl): ValidationErrors | null => {
         const value = control.value;

         if (!value) {
            return null;
         }

         const hasUpperCase = /[A-Z]+/.test(value);

         const hasLowerCase = /[a-z]+/.test(value);

         const hasNumeric = /[0-9]+/.test(value);

         const passwordValid = hasUpperCase && hasLowerCase && hasNumeric;

         return !passwordValid ? { passwordStrength: true } : null;
      };
   }
}
