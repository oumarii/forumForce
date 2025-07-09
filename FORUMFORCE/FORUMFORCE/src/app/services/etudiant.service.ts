import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EtudiantService {

  constructor(private http: HttpClient) { }

  etudinas(): Observable<any[]> {
    return this.http.get<any[]>('http://localhost:8090/api/etudiants/tous');
  }

  ajouterEtudiant(e: any): Observable<any> {
    return this.http.post<any>(`http://localhost:8090/api/etudiants/ajouter`, e);
  }

  supprimerEtudiant(id: number): Observable<any> {
    return this.http.delete<any>(`http://localhost:8090/api/etudiants/supprimer/${id}`);
  }

  mettreAJourEtudiant(id: number, etud: any): Observable<any> {
    return this.http.put<any>(`http://localhost:8090/api/etudiants/modifier/${id}`, etud);
  }
}
