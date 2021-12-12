import { Component, OnInit } from '@angular/core';
import { AccountHolderService } from '../services/account-holder.service';
import {FormControl,FormGroup,Validators} from '@angular/forms';
import { AccountHolderInfo } from './account-holder-info';
import { AccountType } from '../add-account-type/account-type';
import { Observable,Subject } from "rxjs";


@Component({
  selector: 'app-add-account-holder',
  templateUrl: './add-account-holder.component.html',
  styleUrls: ['./add-account-holder.component.css']
})
export class AddAccountHolderComponent implements OnInit {

  constructor(private accountHolderService:AccountHolderService) { }

  accountHolder : AccountHolderInfo=new AccountHolderInfo();
  accountType : AccountType = new AccountType();
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any>= new Subject();


  accounts: Observable<any[]>;
//  account : AccountType=new AccountType();

  submitted = false;

  ngOnInit() {
    this.accountHolderService.getAccountTypeList().subscribe(data =>{
      this.accounts =data;
       this.dtTrigger.next();
      })
    this.submitted=false;
  }

  accountHolderSaveForm=new FormGroup({
    name:new FormControl('' , [Validators.required , Validators.minLength(1)] ),
    age:new FormControl('' , [Validators.required , Validators.minLength(1)] ),
    dob:new FormControl('' , [Validators.required , Validators.minLength(1)] ),
    presentAddress:new FormControl('' , [Validators.required , Validators.minLength(1)] ),
    contactNo:new FormControl('' , [Validators.required , Validators.minLength(1)] ),
    gender:new FormControl('' , [Validators.required , Validators.minLength(1)] ),
    hobby:new FormControl('' , [Validators.required , Validators.minLength(1)] ),
    accountCreateDate:new FormControl('' , [Validators.required , Validators.minLength(1)] ),
    accountType:new FormControl('' , [Validators.required , Validators.minLength(1)] ),

 
  });

  saveAccountHolder(saveAccount: any){
    this.accountHolder=new AccountHolderInfo();
  //  this.accountHolder.id=this.Id.value;

 
    this.accountHolder.name=this.Name.value;
    this.accountHolder.age=this.Age.value;
    this.accountHolder.dob=this.Dob.value;
    this.accountHolder.presentAddress=this.PresentAddress.value;
    this.accountHolder.contactNo=this.ContactNo.value;
    this.accountHolder.gender=this.Gender.value;
    this.accountHolder.hobby=this.Hobby.value;
    this.accountHolder.accountCreateDate=this.AccountCreateDate.value;
    this.accountType.id = this.AccountType.value; 
    this.accountHolder.accountType=this.accountType;
    
    
    console.log(this.AccountType);
    console.log(this.Name);
    console.log(this.Age);
    console.log(this.Dob);
    console.log(this.PresentAddress);
    console.log(this.ContactNo);
    console.log(this.Gender);
    console.log(this.Hobby);
    console.log(this.AccountCreateDate);
    console.log(this.AccountType);

    this.submitted = true;
    this.save();
  }

  

  save() {
    this.accountHolderService.createAccountHolder(this.accountHolder)
      .subscribe(data => console.log(data), error => console.log(error));
    this.accountHolder = new AccountHolderInfo();
  }


  // get Id(){
  //   return this.accountHolderSaveForm.get('id');
  // }



  get Name(){
    return this.accountHolderSaveForm.get('name');
  }

  get Age(){
    return this.accountHolderSaveForm.get('age');
  }

  get Dob(){
    return this.accountHolderSaveForm.get('dob');
  }

  get PresentAddress(){
    return this.accountHolderSaveForm.get('presentAddress');
  }


  get ContactNo(){
    return this.accountHolderSaveForm.get('contactNo');
  }
  get Gender(){
    return this.accountHolderSaveForm.get('gender');
  }

  get Hobby(){
    return this.accountHolderSaveForm.get('hobby');
  }

  get AccountCreateDate(){
    return this.accountHolderSaveForm.get('accountCreateDate');
  }

  get AccountType(){
    return this.accountHolderSaveForm.get('accountType');
  }

  addAccountHolderForm(){
    this.submitted=false;
    this.accountHolderSaveForm.reset();
  }
}
