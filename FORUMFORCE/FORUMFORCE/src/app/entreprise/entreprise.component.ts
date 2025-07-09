import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { toArray } from 'rxjs/operators';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-entreprise',
  templateUrl: './entreprise.component.html',
  styleUrls: ['./entreprise.component.scss']
})
export class EntrepriseComponent {
  nouvel = false;

  entreprises: any[] = [];
  apparitin() { this.nouvel = !this.nouvel }



  constructor(private service: LoginService) {

  }

  ngOnInit(): void {
    this.getUsers();
  }

  getUsers(): void {
    this.service.entreprisef().subscribe(entreprises => this.entreprises = entreprises);
  }
  //ajouter entrep
  ent: any = { "nom": "", "nif": "", "numtel": "", "adresse": "", "e_mail": "", "motPasse": "", "etat": "PAYER", "pack": { "id": 1 } }

  ajouter() {
    this.service.ajouterEntreprise(this.ent).subscribe((res) => { console.log(res); });
    this.ent = { id: 0, "nom": "", "nif": "", "numtel": "", "adresse": "", "e_mail": "", "motPasse": "", "etat": "PAYER", "pack": { "id": 1 } }
    this.getUsers();
    window.location.reload();
  }

  //supprimer entrep

  supprimerEntreprise(id: number) {
    this.service.supprimerEntreprise(id).subscribe(
      (res) => {
        console.log("Entreprise supprimée avec succès :", res);
        window.location.reload();
      },);
  }

  //modifier entrep
  editer(vari: any) {
    this.ent = vari;
    this.apparitin();
  }
  modifierEntreprise(entreprise: any) {
    this.nouvel = !this.nouvel;
    this.service.mettreAJourEntreprise(entreprise.id, entreprise).subscribe(
      (res) => {
        window.location.reload();
      },
    );
  }





  // Fonction de recherche entrep
  termRecherche: string = '';
  rechercherEntreprise(): void {
    if (!this.termRecherche.trim()) {
      this.getUsers(); // Si le terme de recherche est vide, afficher toutes les entreprises
      return;
    }
    this.entreprises = this.entreprises.filter((entreprise: any) => {
      return entreprise.nom.toLowerCase().includes(this.termRecherche.toLowerCase());
    });
  }

}
