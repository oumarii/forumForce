import { Component } from '@angular/core';
import { FeedbackService } from '../services/feedback.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.scss']
})
export class FeedbackComponent {

  constructor(private service: FeedbackService, private router: Router) {
  }
  nouvel = false;

  apparition_Formu() { this.nouvel = !this.nouvel }




  Feed: any = {
    "id": 1,
    "feedback": "",
  };


  ajouter() {
    this.service.ajouterFeed(this.Feed).subscribe((res) => { console.log(res); });
    console.log(this.Feed);
    this.Feed = {
      "id": 1,
      "feedback": "",
    }
    this.router.navigate(['/login']);

  }





}