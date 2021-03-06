import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AccountTypeListComponent } from './account-type-list.component';

describe('StudentListComponent', () => {
  let component: AccountTypeListComponent;
  let fixture: ComponentFixture<AccountTypeListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AccountTypeListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AccountTypeListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
