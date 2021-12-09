import { AccountType } from "../add-account-type/account-type";

export class AccountHolderInfo {

    id:number;
    name:string;
    age:number;
    dob:Date;
    presentAddress:string;
    contactNo:string;
    gender:string;
    hobby:string;
    accountCreateDate:Date;
    accountType:AccountType;
    
}