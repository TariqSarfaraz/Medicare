import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerprofileupdateComponent } from './customerprofileupdate.component';

describe('CustomerprofileupdateComponent', () => {
  let component: CustomerprofileupdateComponent;
  let fixture: ComponentFixture<CustomerprofileupdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerprofileupdateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerprofileupdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
