import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'; 
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class LocationService {
  private baseUrl = 'http://localhost:8080/ftpLocation/';  
  constructor(private http:HttpClient) { }
  createFTPLocation(location: object): Observable<string> {  
    return this.http.post<string>(`${this.baseUrl}`+'createFTPLocation', location);  
  }
  // deleteFTPLocation(id: number): Observable<any> {  
  //   return this.http.delete(`${this.baseUrl}/deleteFTPLocation/${id}`, { responseType: 'text' });  
  // }  

  // updateFTPLocation(id: number, value: any): Observable<Object> {  
  //   return this.http.patch(`${this.baseUrl}/updateFTPLocation/${id}`, value);  
  // }  
}
