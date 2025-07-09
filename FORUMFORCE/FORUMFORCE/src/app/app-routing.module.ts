import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LayoutComponent } from './layout/layout.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { EntrepriseComponent } from './entreprise/entreprise.component';
import { GroupeComponent } from './groupes/groupes.component';
import { TacheComponent } from './tache/tache.component';
import { PlanningComponent } from './planning/planning.component';
import { FormulaireComponent } from './formulaire/formulaire.component';
import { PlanninEntrepriseComponent } from './plannin-entreprise/plannin-entreprise.component';
import { PacksComponent } from './packs/packs.component';
import { EtudiantComponent } from './etudiant/etudiant.component';
import { DepenseComponent } from './depense/depense.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { FeedAfficheComponent } from './feed-affiche/feed-affiche.component';



const routes: Routes = [
  {
    path: '', redirectTo: '/login', pathMatch: 'full',
  },
  { path: 'formulaire', component: FormulaireComponent },
  { path: 'feedback', component: FeedbackComponent },

  { path: 'planningentreprise', component: PlanninEntrepriseComponent },
  {
    path: 'site', component: LayoutComponent,
    children: [
      { path: 'entreprise', component: EntrepriseComponent, },
      { path: 'groupes', component: GroupeComponent, },
      { path: 'tache', component: TacheComponent, },
      { path: 'depence', component: DepenseComponent, },
      { path: 'dashboard', component: DashboardComponent, },
      { path: 'planning', component: PlanningComponent, },
      { path: 'packs', component: PacksComponent, },
      { path: 'feedbackAFF', component: FeedAfficheComponent, },
      { path: 'etudiant', component: EtudiantComponent, },
    ],
  },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule { }
