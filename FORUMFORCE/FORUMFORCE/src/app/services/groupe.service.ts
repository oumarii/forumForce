import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GroupeService {

  constructor(private http: HttpClient) { }

  getgroupes(): Observable<any[]> {
    return this.http.get<any[]>('http://localhost:8090/api/groupes/tous');
  }

  ajouterGroupe(entreprise: any): Observable<any> {
    return this.http.post<any>(`http://localhost:8090/api/groupes/ajouter`, entreprise);
  }

  supprimerGroupe(id: number): Observable<any> {
    return this.http.delete<any>(`http://localhost:8090/api/groupes/supprimer/${id}`);
  }

  mettreAJouGpoupe(id: number, entreprise: any): Observable<any> {
    return this.http.put<any>(`http://localhost:8090/api/groupes/modifier/${id}`, entreprise);
  }

}