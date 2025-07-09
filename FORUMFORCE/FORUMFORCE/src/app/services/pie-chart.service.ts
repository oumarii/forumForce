import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PieChartService {

  constructor(private _http: HttpClient) { }


  getSommeGain(): Observable<any> {
    return this._http.get('http://localhost:8090/entreprise/somme-etat-payer');
  }
  getSommeDepense(): Observable<any> {
    return this._http.get('http://localhost:8090/depense/somme-montant');
  }



}
