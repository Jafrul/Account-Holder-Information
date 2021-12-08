import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AccountTypeListComponent } from './account-type-list/account-type-list.component';
import { AccountHolderListComponent } from './account-holder-list/account-holder-list.component';
import { AddAccountTypeComponent } from './add-account-type/add-account-type.component';
import { AddAccountHolderComponent } from './add-account-holder/add-account-holder.component';

const routes: Routes = [
  { path: '', redirectTo: 'view-account-holder', pathMatch: 'full' },
  { path: 'add-account-holder', component: AddAccountHolderComponent },
  { path: 'view-account-holder', component: AccountHolderListComponent },
  { path: 'view-account', component: AccountTypeListComponent },
  { path: 'add-account', component: AddAccountTypeComponent }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
