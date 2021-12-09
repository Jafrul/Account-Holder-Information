import { Injectable, Component } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class AccountHolderService {

  private baseUrl = 'http://localhost:8080/v1/';
  private baseUrls = 'http://localhost:8080/v1/';
  constructor(private http:HttpClient) { }

  

  getAccountHolderList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`+'accountinfo');
  }

  createAccountHolder(accountHolderInfo: any): Observable<any> {
    return this.http.post(`${this.baseUrl}`+'accountinfo', accountHolderInfo);
  }

  deleteAccountHolder(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}accountinfo/${id}`, { responseType: 'text' });
  }

  getAccountHolderById(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}accountinfo/${id}`);
  }

  updateAccountHolder(id: number, value: any ): Observable<any> {
    return this.http.put(`${this.baseUrl}accountinfo/${value.id}`, value);
  }
  getAccountTypeList(): Observable<any> {
    return this.http.get(`${this.baseUrls}`+'accounts');
  }
  
}                                           