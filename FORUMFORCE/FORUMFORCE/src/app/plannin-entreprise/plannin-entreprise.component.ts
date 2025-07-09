import { Component } from '@angular/core';
import { PlanningService } from '../services/planning.service';

@Component({
  selector: 'app-plannin-entreprise',
  templateUrl: './plannin-entreprise.component.html',
  styleUrls: ['./plannin-entreprise.component.scss']
})
export class PlanninEntrepriseComponent {

  constructor(private service: PlanningService) {
    this.getUSeances();
    this.getlogistique();
  }




  logi: any = {
    "id": 1,
    "lieu": "",
    "dateEv": ""
  };


  seances: any[] = [];
  getUSeances(): void {
    this.service.afficherSeace().subscribe(a => this.seances = a);
  }



  getlogistique(): void {
    this.service.rempliform_D_L().subscribe(a => this.logi = a);
  }



}
