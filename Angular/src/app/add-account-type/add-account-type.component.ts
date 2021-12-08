import { Component, OnInit } from '@angular/core';
import { AccountTypeService } from '../account-type.service';
import {FormControl,FormGroup,Validators} from '@angular/forms';
import { AccountType } from '../account-type';
@Component({
  selector: 'app-add-account-type',
  templateUrl: './add-account-type.component.html',
  styleUrls: ['./add-account-type.component.css']
})
export class AddAccountTypeComponent implements OnInit {

  constructor(private accounttypeservice:AccountTypeService) { }

  account : AccountType=new AccountType();
  submitted = false;

  ngOnInit() {
    this.submitted=false;
  }

  accountsaveform=new FormGroup({
    type:new FormControl('' , [Validators.required , Validators.minLength(1)] ),
  
  });

  saveAccountType(saveAccount: any){
    this.account=new AccountType();
    this.account.type=this.Type.value;
    console.log('Type --- ' + this.Type);
    this.submitted = true;
    this.save();
  }

  

  save() {
    this.accounttypeservice.createAccountType(this.account)
      .subscribe(data => console.log(data), error => console.log(error));
    this.account = new AccountType();
  }

  get Type(){
    return this.accountsaveform.get('type');
  }



  addAccountTypeForm(){
    this.submitted=false;
    this.accountsaveform.reset();
  }
}
