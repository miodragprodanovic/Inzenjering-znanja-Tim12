import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { GetBetterComponent } from '../model/get-better-component';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AppService {
  private getBetterComponentUrl: string;
  private getComputerPurposeUrl: string;
  private getComputerErrorUrl: string;

  constructor(private http: HttpClient) { 
    this.getBetterComponentUrl = 'http://localhost:8080/getBetterComponent'
    this.getComputerPurposeUrl = 'http://localhost:8080/getComputerPurpose'
    this.getComputerErrorUrl = 'http://localhost:8080/getComputerError'
  }

  public getBetterComponent(component: GetBetterComponent): Observable<Array<String>> {
    return this.http.post<Array<String>>(this.getBetterComponentUrl, component);
  }

  public getComputerPurpose(component: GetBetterComponent): Observable<Array<String>> {
    return this.http.post<Array<String>>(this.getComputerPurposeUrl, component);
  }

  public getComputerError(component: GetBetterComponent): Observable<Array<String>> {
    return this.http.post<Array<String>>(this.getComputerErrorUrl, component);
  }
}
