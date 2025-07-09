import { Component } from '@angular/core';
import { SideNavItem } from '../models/models';

@Component({
  selector: 'app-side-nav',
  templateUrl: './side-nav.component.html',
  styleUrls: ['./side-nav.component.scss']
})
export class SideNavComponent {
  sideNavContent: SideNavItem[] = [
    {
      title: 'Acceuil',
      link: 'site/dashboard',

    },
    {
      title: 'Entreprises',
      link: 'site/entreprise',
    },
    {
      title: 'Groupes',
      link: 'site/groupes',
    },
    {
      title: 'Taches',
      link: 'site/tache',
    },
    {
      title: 'Planning',
      link: 'site/planning',
    },
    {
      title: 'packs',
      link: 'site/packs',
    },
    {
      title: 'feedback',
      link: 'site/feedbackAFF',
    },

    {
      title: 'Logout',
      link: 'login',
    }

  ];
}
