import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AccountHolderListComponent } from './account-holder-list.component';

describe('AccountHolderListComponent', () => {
  let component: AccountHolderListComponent;
  let fixture: ComponentFixture<AccountHolderListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AccountHolderListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AccountHolderListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
