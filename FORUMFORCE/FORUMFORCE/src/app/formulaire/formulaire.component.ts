import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Login1Service } from '../login1.service';
import { LoginService } from '../services/login.service';


@Component({
  selector: 'app-formulaire',
  templateUrl: './formulaire.component.html',
  styleUrls: ['./formulaire.component.scss']
})
export class FormulaireComponent {
  constructor(private router: Router, private service: LoginService) { }
  // entreprise: Entreprise = new Entreprise(); // Modèle d'entreprise pour stocker les données du formulaire
  packBasique: boolean = false;
  packStandard: boolean = false;
  packPremium: boolean = false;
  toplanning() {
    this.router.navigate(["planningentreprise"])
  }
  remplirFeed() {
    this.router.navigate(["feedback"])
  }
  //constructor(private entrepriseService: EntrepriseService) { }
  ent: any = { id: 0, "nom": "", "nif": "", "numtel": "", "adresse": "", "e_mail": "", "motPasse": "", "etat": "PAYER", "pack": { "id": 2 } }
  code = "";
  ajouterEntreprise() {
    if (this.code == "forum*") {
      this.service.ajouterEntreprise(this.ent).subscribe((res) => { console.log(res); });
      this.ent = { id: 0, "nom": "", "nif": "", "numtel": "", "adresse": "", "e_mail": "", "motPasse": "", "etat": "PAYER", "pack": { "id": 2 } }

      window.location.reload();
    }
    else {
      alert("Error:Verifier vos données");
    }
  }
}

