import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {

  constructor(private http: HttpClient) { }

  afficherFeed(): Observable<any[]> {
    return this.http.get<any[]>(`http://localhost:8090/feedbacks/afficher`);
  }

  supprimerFeed(id: number): Observable<any> {
    return this.http.delete<any>(`http://localhost:8090/feedbacks/supprimer/${id}`);
  }

  ajouterFeed(e: any): Observable<any> {
    return this.http.post<any>(`http://localhost:8090/feedbacks/ajouter`, e);
  }
}
