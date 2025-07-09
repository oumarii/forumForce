import { Component, OnInit } from '@angular/core';
import { GroupeService } from '../services/groupe.service';

@Component({
  selector: 'app-groupes',
  templateUrl: './groupes.component.html',
  styleUrls: ['./groupes.component.scss']
})
export class GroupeComponent implements OnInit {
  nouvel = false;


  apparitin() { this.nouvel = !this.nouvel }
  groupes: any[] = [];
  afficherNouveauGroupe: boolean = false;
  afficherEditerGroupe: boolean = false;
  editerMode: boolean = false;
  groupe: any = {
    id: 0,
    "nom_groupe": ""
  };
  searchTerm: string = '';
  constructor(private service: GroupeService) { }


  ngOnInit(): void {
    this.getgroupes();
  }

  getgroupes(): void {
    this.service.getgroupes().subscribe(a => this.groupes = a);
  }



  nouveauGroupe() {
    this.service.ajouterGroupe(this.groupe).subscribe((res) => { console.log(res); });
    this.groupe = { id: 0, "nom_groupe": "" }
    this.getgroupes();
    window.location.reload()
  }



  editerGroupeForm(groupe: any): void {
    this.groupe = { ...groupe }; // Crée une copie de l'objet groupe pour éviter de modifier l'original directement
    this.editerMode = true;
    this.afficherEditerGroupe = true;
  }




  supprimerGroupe(id: number) {
    this.service.supprimerGroupe(id).subscribe(
      (res) => {
        window.location.reload();
      },);
  }


  termRecherche: string = '';
  rechercherGroupe(): void {
    if (!this.termRecherche.trim()) {
      this.getgroupes();
      return;
    }
    this.groupes = this.groupes.filter((g: any) => {
      return g.nom_groupe.toLowerCase().includes(this.termRecherche.toLowerCase());
    });
  }


  editer(vari: any) {
    this.groupe = vari;
    this.apparitin();
  }
  modifierGroupe(entreprise: any) {
    this.nouvel = !this.nouvel;
    this.service.mettreAJouGpoupe(entreprise.id, entreprise).subscribe(
      (res) => {
        window.location.reload();
      },
    );
  }

}