import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class AccountTypeService {

  private baseUrl = 'http://localhost:8080/v1/';

  constructor(private http:HttpClient) { }

  getAccountTypeList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`+'accounts');
  }

  createAccountType(account: object): Observable<object> {
    return this.http.post(`${this.baseUrl}`+'accounts', account);
  }

  deleteAccountType(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}accounts/${id}`, { responseType: 'text' });
  }

  getAccount(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}accounts/${id}`);
  }

  updateAccountType(id: number, value: any ): Observable<any> {
    return this.http.put(`${this.baseUrl}accounts/${value.id}`, value);
  }
  
}                                           