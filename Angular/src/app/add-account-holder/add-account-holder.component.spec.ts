import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddAccountHolderComponent } from './add-account-holder.component';

describe('AddAccountHolderComponent', () => {
  let component: AddAccountHolderComponent;
  let fixture: ComponentFixture<AddAccountHolderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddAccountHolderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddAccountHolderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
