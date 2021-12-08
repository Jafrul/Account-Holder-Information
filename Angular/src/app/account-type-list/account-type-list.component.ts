import { Component, OnInit } from '@angular/core';
import { AccountTypeService } from '../account-type.service';
import { AccountType } from '../account-type';
import { Observable,Subject } from "rxjs";

import {FormControl,FormGroup,Validators} from '@angular/forms';

@Component({
  selector: 'app-account-type-list',
  templateUrl: './account-type-list.component.html',
  styleUrls: ['./account-type-list.component.css']
})
export class AccountTypeListComponent implements OnInit {

 constructor(private accounttypeservice:AccountTypeService) { }

  accountsArray: any[] = [];
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any>= new Subject();


  accounts: Observable<any[]>;
  account : AccountType=new AccountType();
  deleteMessage=false;
  accountlist:any;
  isupdated = false;    
 

  ngOnInit() {
    this.isupdated=false;
    this.dtOptions = {
      pageLength: 6,
      stateSave:true,
      lengthMenu:[[5, 10, 15, -1], [5, 10, 15, "All"]],
      processing: true
    };   
    this.accounttypeservice.getAccountTypeList().subscribe(data =>{
    this.accounts =data;
    this.dtTrigger.next();
    })
  }
  
  deleteAccountType(id: number) {
    this.accounttypeservice.deleteAccountType(id)
      .subscribe(
        data => {
          console.log(data);
          this.deleteMessage=true;
          this.accounttypeservice.getAccountTypeList().subscribe(data => {
            this.accounts =data
            })
        },
        error => console.log(error));
  }


  updateAccount(id: number){
    

    this.accounttypeservice.getAccount(id)
      .subscribe(
        data => {
          console.log(data['type']);
          console.log(data['id']);
          this.account=data           
        },
        error => console.log(error));
        
  }

  accounttypeupdateform=new FormGroup({
    id:new FormControl(),
    type:new FormControl()
    
  });

  updateAcc(updacc:any){
    this.account=new AccountType(); 
   this.account.id=this.Id.value;
   this.account.type=this.Type.value;
   console.log(this.Type.value);
   console.log(this.Id.value);
   

   this.accounttypeservice.updateAccountType(this.account.id, this.account).subscribe(
    data => {     
      this.isupdated=true;
      this.accounttypeservice.getAccountTypeList().subscribe(data =>{
        console.log(data)
        this.accounts =data
        })
    },
    error => console.log(error));
  }

  get Id(){
    return this.accounttypeupdateform.get('id');
  }



  get Type(){
    return this.accounttypeupdateform.get('type');
  }

 

  changeisUpdate(){
    this.isupdated=false;
  }
}
