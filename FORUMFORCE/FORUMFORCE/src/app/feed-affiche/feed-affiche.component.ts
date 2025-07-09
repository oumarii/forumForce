import { Component } from '@angular/core';
import { FeedbackService } from '../services/feedback.service';

@Component({
  selector: 'app-feed-affiche',
  templateUrl: './feed-affiche.component.html',
  styleUrls: ['./feed-affiche.component.scss']
})
export class FeedAfficheComponent {
  constructor(private service: FeedbackService) {
    this.getFeedback();
  }


  Feed: any = {
    "id": 1,
    "feedback": "",
  };
  Feeds: any[] = [];
  getFeedback(): void {
    this.service.afficherFeed().subscribe(a => this.Feeds = a);
  }


  supprimerFeed(id: number) {
    this.service.supprimerFeed(id).subscribe(
      (res) => {
        console.log("feed supprimée avec succès :", res);
        window.location.reload();

      },
      (error) => {
        console.error("Erreur lors de la suppression de feedback :", error);
      }
    );
  }

}
