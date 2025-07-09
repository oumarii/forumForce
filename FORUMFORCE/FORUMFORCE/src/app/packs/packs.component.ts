import { Component } from '@angular/core';
import { PackService } from '../pack.service';

@Component({
  selector: 'app-packs',
  templateUrl: './packs.component.html',
  styleUrls: ['./packs.component.scss']
})
export class PacksComponent {


  pack = {
    id: 0,
    "prix": 0,
    "type": "",
    "description": "",
    "nbrePlaceLimite": 0
  }
  packs: any[] = [];

  constructor(private service: PackService) { }

  ngOnInit(): void {
    this.afficher();
  }

  // Méthode pour afficher ou masquer le formulaire d'ajout de tâche


  afficher() {
    this.service.afficher().subscribe(
      taches => this.packs = taches
    );

  }
  ajouter() {

    this.service.ajouter(this.pack).subscribe(res => { });
    this.pack = {
      id: 0,
      "prix": 0,
      "type": "",
      "description": "",
      "nbrePlaceLimite": 0

    }
    window.location.reload();

  }

  editer(pac: any) {

    this.pack = pac;

    window.scrollTo({
      top: 0,
      behavior: 'smooth' // Pour un défilement fluide, utilisez 'smooth'
    });
  }

  supprimer(id: number) {

    this.service.supprimer(id).subscribe((res) => {
      console.log("Entreprise supprimée avec succès :", res);
      window.location.reload();
    },);

  }
}
