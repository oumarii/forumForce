import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class Login1Service {

  constructor(private http: HttpClient) { }


  admiin(): Observable<any> {
    return this.http.get<any>(`http://localhost:8090/api/admins/get/19`);

  }
  affiche(): Observable<any[]> {
    return this.http.get<any[]>('http://localhost:8090/api/admins/all');
  }
}
