
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { CoreService } from '../core/core.service';
import { TacheService } from '../tache.service';
@Component({
  selector: 'app-tache',
  templateUrl: './tache.component.html',
  styleUrls: ['./tache.component.scss']
})
export class TacheComponent {

  taches: any[] = []; // Array pour stocker les tâches
  afficherNouvelleTache: boolean = false; // Variable pour contrôler l'affichage du formulaire d'ajout de tâche
  tache: any = {
    "id": "0",
    "dateDebut": "",
    "dateFin": "",
    "nom": "",
    "finish": false,
    "groupe": {
      "id": 0
    }
  }

  constructor(private service: TacheService) { }

  ngOnInit(): void {
    this.afficher();
  }

  // Méthode pour afficher ou masquer le formulaire d'ajout de tâche
  nouvelleTache(): void {
    this.afficherNouvelleTache = !this.afficherNouvelleTache;
  }

  afficher() {
    this.service.afficher_tache().subscribe(
      taches => this.taches = taches
    );

  }
  ajouter() {

    this.service.ajouter_tache(this.tache).subscribe((res) => { console.log(res) });
    this.tache = {
      "id": "0",
      "dateDebut": "",
      "dateFin": "",
      "nom": "",
      "finish": false,
      "groupe": {
        "id": 0
      }
    };
    window.location.reload();
  }





  supprimerT(id: number) {
    this.service.supprimerTach(id).subscribe(
      (res) => {
        console.log("tache supprimée avec succès :", res);
        window.location.reload();
      },);
  }

  editer(vari: any) {
    this.tache = vari;
    this.nouvelleTache();
  }
  modifierT(e: any) {
    this.afficherNouvelleTache = !this.afficherNouvelleTache;
    this.service.mettreAJourTach(e.id, e).subscribe(
      (res) => {
        window.location.reload();
      },
    );
  }



  termRecherche: string = '';
  rechercherT(): void {
    if (!this.termRecherche.trim()) {
      this.afficher();
      return;
    }
    this.taches = this.taches.filter((e: any) => {
      return e.nom.toLowerCase().includes(this.termRecherche.toLowerCase());
    });
  }


}
