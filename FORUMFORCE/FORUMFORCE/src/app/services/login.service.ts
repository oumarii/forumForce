import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class LoginService {

  constructor(private http: HttpClient) { }

  entreprisef(): Observable<any[]> {
    return this.http.get<any[]>('http://localhost:8090/entreprise/afficher');
  }

  ajouterEntreprise(entreprise: any): Observable<any> {
    return this.http.post<any>(`http://localhost:8090/entreprise/ajouter`, entreprise);
  }

  supprimerEntreprise(id: number): Observable<any> {
    return this.http.delete<any>(`http://localhost:8090/entreprise/supprimer/${id}`);
  }

  mettreAJourEntreprise(id: number, entreprise: any): Observable<any> {
    return this.http.put<any>(`http://localhost:8090/entreprise/modifier/${id}`, entreprise);
  }

}
