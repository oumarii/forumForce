import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TacheService {

  constructor(private http: HttpClient) { }

  afficher_tache(): Observable<any[]> {
    return this.http.get<any[]>('http://localhost:8090/api/taches/all');
  }
  ajouter_tache(tache: any): Observable<any[]> {
    return this.http.post<any[]>('http://localhost:8090/api/taches/add', tache);
  }

  supprimerTach(id: number): Observable<any> {
    return this.http.delete<any>(`http://localhost:8090/api/taches/delete/${id}`);
  }

  mettreAJourTach(id: number, etud: any): Observable<any> {
    return this.http.put<any>(`http://localhost:8090/api/taches/modifier/${id}`, etud);
  }


}
