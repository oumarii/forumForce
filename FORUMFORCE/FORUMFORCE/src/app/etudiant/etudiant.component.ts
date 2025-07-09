import { Component } from '@angular/core';
import { EtudiantService } from '../services/etudiant.service';

@Component({
  selector: 'app-etudiant',
  templateUrl: './etudiant.component.html',
  styleUrls: ['./etudiant.component.scss']
})
export class EtudiantComponent {
  nouvel = false;

  etudiants: any[] = [];
  apparitin() { this.nouvel = !this.nouvel }
  constructor(private service: EtudiantService) { }

  ngOnInit(): void {
    this.getUsers();
  }

  getUsers(): void {
    this.service.etudinas().subscribe(e => this.etudiants = e);
    console.log(this.etudiants);
  }

  ent: any = {
    id: 0,
    "nom": "",
    "prenom": "",
    "numTele": "",
    "age": 0,
    "cin": "",
    "sexe": "",
    "niveau": "",
    "ecole": "",
    "grpp": {
      id: 0,
    }
  }

  ajouter() {
    this.service.ajouterEtudiant(this.ent).subscribe((res) => { console.log(res); });
    this.ent = {
      id: 0,
      "nom": "",
      "prenom": "",
      "numTele": "",
      "age": 0,
      "cin": "",
      "sexe": "",
      "niveau": "",
      "ecole": "",
      "grpp": {
        id: 0,
      }
    }
    this.getUsers();
    window.location.reload();
  }


  supprimerEtd(id: number) {
    this.service.supprimerEtudiant(id).subscribe(
      (res) => {
        console.log("etd supprimée avec succès :", res);
        window.location.reload();
      },);
  }

  editer(vari: any) {
    this.ent = vari;
    this.apparitin();
  }
  modifierEtd(e: any) {
    this.nouvel = !this.nouvel;
    this.service.mettreAJourEtudiant(e.id, e).subscribe(
      (res) => {
        window.location.reload();
      },
    );
  }



  termRecherche: string = '';
  rechercherEtd(): void {
    if (!this.termRecherche.trim()) {
      this.getUsers();
      return;
    }
    this.etudiants = this.etudiants.filter((e: any) => {
      return e.nom.toLowerCase().includes(this.termRecherche.toLowerCase());
    });
  }




}
