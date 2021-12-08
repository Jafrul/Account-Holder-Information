import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import {DataTablesModule} from 'angular-datatables';
import { AccountTypeListComponent } from './account-type-list/account-type-list.component';
import { AddAccountTypeComponent } from './add-account-type/add-account-type.component';
import { AddAccountHolderComponent } from './add-account-holder/add-account-holder.component';
import { AccountHolderListComponent } from './account-holder-list/account-holder-list.component';

@NgModule({
  declarations: [
    AppComponent,
    AccountTypeListComponent,
    AddAccountTypeComponent,
    AddAccountHolderComponent,
    AccountHolderListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    DataTablesModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
