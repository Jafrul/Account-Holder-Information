import { Component, OnInit } from '@angular/core';
import { AccountHolderService } from '../account-holder.service';
import { AccountHolderInfo } from '../account-holder-info';
import { Observable,Subject } from "rxjs";
import {FormControl,FormGroup,Validators} from '@angular/forms';

@Component({
  selector: 'app-account-holder-list',
  templateUrl: './account-holder-list.component.html',
  styleUrls: ['./account-holder-list.component.css']
})
export class AccountHolderListComponent implements OnInit {

  constructor(private accountHolderService:AccountHolderService) { }

  accountsArray: any[] = [];
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any>= new Subject();


  accountHolders: Observable<any[]>;
  accountHolder : AccountHolderInfo=new AccountHolderInfo();
  accountType: String;
  deleteMessage=false;
  accountlist:any;
  isupdated = false;    
 

  ngOnInit() {
    this.isupdated=false;
    this.dtOptions = {
      pageLength: 10,
      stateSave:true,
      lengthMenu:[[5, 10, 15, -1], [5, 10, 15, "All"]],
      processing: true
    };   
    this.accountHolderService.getAccountHolderList().subscribe(data =>{
      debugger;
    this.accountHolders =data;
    this.dtTrigger.next();
    })
  }
  
  deleteAccountHolder(id: number) {
    this.accountHolderService.deleteAccountHolder(id)
      .subscribe(
        data => {
          console.log(data);
          this.deleteMessage=true;
          this.accountHolderService.getAccountHolderList().subscribe(data => {
            this.accountHolders =data
            })
        },
        error => console.log(error));
  }


  updateAccountHolder(id: number){
    

    this.accountHolderService.getAccountHolderById(id)
      .subscribe(
        data => {
          console.log(data['name']);
          console.log(data['id']);
          this.accountHolder=data 
          this.accountType= data.accountType.type      
        },
        error => console.log(error));
        
  }

  accountHolderUpdateForm=new FormGroup({
    id:new FormControl(),
    name:new FormControl(),
    age:new FormControl(),
    dob:new FormControl(),
    presentAddress:new FormControl(),
    contactNo:new FormControl(),
    gender:new FormControl(),
    hobby:new FormControl(),
    accountCreateDate:new FormControl(),
    accountType:new FormControl(),
    
    
  });

  updateAccHolder(updaccholder:any){
    this.accountHolder=new AccountHolderInfo(); 
   this.accountHolder.id=this.Id.value;
   this.accountHolder.name=this.Name.value;
   this.accountHolder.age=this.Age.value;
   this.accountHolder.dob=this.Dob.value;
   this.accountHolder.presentAddress=this.PresentAddress.value;
   this.accountHolder.contactNo=this.ContactNo.value;
   this.accountHolder.gender=this.Gender.value;
   this.accountHolder.hobby=this.Hobby.value;
   this.accountHolder.accountCreateDate=this.AccountCreateDate.value;
   this.accountHolder.accountType=this.AccountType.value;
   
   console.log(this.Name.value);
   console.log(this.Id.value);
   

   this.accountHolderService.updateAccountHolder(this.accountHolder.id, this.accountHolder).subscribe(
    data => {     
      this.isupdated=true;
      this.accountHolderService.getAccountHolderList().subscribe(data =>{
        console.log(data)
        this.accountHolders =data
        })
    },
    error => console.log(error));
  }

  get Id(){
    return this.accountHolderUpdateForm.get('id');
  }


  get Name(){
    return this.accountHolderUpdateForm.get('name');
  }

  get Age(){
    return this.accountHolderUpdateForm.get('age');
  }

  get Dob(){
    return this.accountHolderUpdateForm.get('dob');
  }

  get PresentAddress(){
    return this.accountHolderUpdateForm.get('presentAddress');
  }

  get ContactNo(){
    return this.accountHolderUpdateForm.get('contactNo');
  }

  get Gender(){
    return this.accountHolderUpdateForm.get('gender');
  }

  get Hobby(){
    return this.accountHolderUpdateForm.get('hobby');
  }

  get AccountCreateDate(){
    return this.accountHolderUpdateForm.get('accountCreateDate');
  }

  get AccountType(){
    return this.accountHolderUpdateForm.get('accountType');
  }



  changeisUpdate(){
    this.isupdated=false;
  }

}
