import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminaddproductsComponent } from './adminaddproducts.component';

describe('AdminaddproductsComponent', () => {
  let component: AdminaddproductsComponent;
  let fixture: ComponentFixture<AdminaddproductsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminaddproductsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminaddproductsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
