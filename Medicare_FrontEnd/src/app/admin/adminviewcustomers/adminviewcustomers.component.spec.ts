import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminviewcustomersComponent } from './adminviewcustomers.component';

describe('AdminviewcustomersComponent', () => {
  let component: AdminviewcustomersComponent;
  let fixture: ComponentFixture<AdminviewcustomersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminviewcustomersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminviewcustomersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
