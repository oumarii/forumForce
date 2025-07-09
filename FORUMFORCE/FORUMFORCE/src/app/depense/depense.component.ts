import { Component } from '@angular/core';
import { DepenceService } from '../depence.service';

@Component({
  selector: 'app-depense',
  templateUrl: './depense.component.html',
  styleUrls: ['./depense.component.scss']
})
export class DepenseComponent {

  depences: any[] = [];

  depence = {
    id: 0,
    "montant": 0,
    "description": "",
    "numFacture": 0
  }



  constructor(private service: DepenceService) { }

  ngOnInit(): void {
    this.afficher();
  }

  // Méthode pour afficher ou masquer le formulaire d'ajout de tâche

  afficher() {
    this.service.afficher_depence().subscribe(depences => this.depences = depences);

  }

  ajouter() {

    this.service.ajouter(this.depence).subscribe((res) => { console.log(res) });

    window.location.reload();
  }

  editer(d: any) {

    this.depence = d;
    window.scrollTo({
      top: 0,

      behavior: 'smooth' // This makes the scrolling smooth
    });
  }
  supprimer(id: number) {
    this.service.supprimer(id).subscribe(
      (res) => {
        console.log("etd supprimée avec succès :", res);
        window.location.reload();
      },);
  }

}
