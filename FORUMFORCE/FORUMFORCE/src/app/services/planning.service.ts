import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PlanningService {

  constructor(private http: HttpClient) { }

  rempliform_D_L(): Observable<any> {
    return this.http.get<any>('http://localhost:8090/logistique/1');
  }

  mettreAJourLogistique(logistique: any): Observable<any> {
    return this.http.post<any>(`http://localhost:8090/logistique/ajouter`, logistique);
  }
  afficherSeace(): Observable<any[]> {
    return this.http.get<any[]>(`http://localhost:8090/seance/afficher`);
  }

  mettreAJourSeance(id: number, s: any): Observable<any> {
    return this.http.put<any>(`http://localhost:8090/seance/modifier/${id}`, s);
  }

  supprimerSeance(id: number): Observable<any> {
    return this.http.delete<any>(`http://localhost:8090/seance/supprimer/${id}`);
  }

  ajouterSeance(entreprise: any): Observable<any> {
    return this.http.post<any>(`http://localhost:8090/seance/ajouter`, entreprise);
  }
}
