import { Component } from '@angular/core';
import { PlanningService } from '../services/planning.service';

@Component({
  selector: 'app-planning',
  templateUrl: './planning.component.html',
  styleUrls: ['./planning.component.scss']
})
export class PlanningComponent {

  nouvel = false;

  apparition_Formu() { this.nouvel = !this.nouvel }

  constructor(private service: PlanningService) {
    this.getUSeances();
    this.getlogistique();

  }
  logi: any = {
    "id": 1,
    "lieu": "",
    "dateEv": ""
  };

  seanc: any = {

    "temp_deb": "",
    "temp_fin": "",
    "sujet": "",
    "animateurs": {
      "id": 0,

    }
  }
  //gestion des seance 


  seances: any[] = [];
  getUSeances(): void {
    this.service.afficherSeace().subscribe(a => this.seances = a);
  }
  ajouter() {
    this.service.ajouterSeance(this.seanc).subscribe((res) => { console.log(res); });
    console.log(this.seanc);
    this.seanc = {
      "temp_deb": "",
      "temp_fin": "",
      "sujet": "",
      "animateurs": {
        "id": 0,

      }
    }

    this.apparition_Formu();
    this.getUSeances();
    window.location.reload();
  }


  supprimerESeance(id: number) {
    this.service.supprimerSeance(id).subscribe(
      (res) => {
        console.log("seance supprimée avec succès :", res);
        window.location.reload();

      },
      (error) => {
        console.error("Erreur lors de la suppression de l'entreprise :", error);
      }
    );
  }

  editer(vari: any) {
    this.seanc = vari;
    this.apparition_Formu();
  }


  Edit: boolean = false;

  getlogistique(): void {
    this.service.rempliform_D_L().subscribe(a => this.logi = a);
  }

  ngOnInit(): void {

  }

  Editer() {
    this.Edit = !this.Edit;
  }
  modifierlogistique() {
    this.Editer();
    this.service.mettreAJourLogistique(this.logi).subscribe(

      (res) => {
        console.log(res);
        window.location.reload();
      },
      (error) => {
        console.error("Erreur lors de la modification de l'entreprise :", error);
      }
    );
  }

}
