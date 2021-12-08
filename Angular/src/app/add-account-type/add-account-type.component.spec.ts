import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddAccountTypeComponent } from './add-account-type.component';

describe('AddStudentComponent', () => {
  let component: AddAccountTypeComponent;
  let fixture: ComponentFixture<AddAccountTypeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddAccountTypeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddAccountTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
