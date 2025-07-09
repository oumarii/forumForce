import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DepenceService {

  constructor(private http: HttpClient) { }

  afficher_depence(): Observable<any[]> {
    return this.http.get<any[]>('http://localhost:8090/depense/afficher');
  }
  ajouter(depence: any): Observable<any[]> {
    return this.http.post<any[]>('http://localhost:8090/depense/ajouter', depence);
  }

  supprimer(id: number): Observable<any> {
    return this.http.delete<any>(`http://localhost:8090/depense/supprimer/${id}`);
  }
}
