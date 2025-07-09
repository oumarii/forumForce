import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatRadioModule } from '@angular/material/radio';
import { MatSelectModule } from '@angular/material/select';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { LayoutComponent } from './layout/layout.component';
import { HeaderComponent } from './header/header.component';
import { MatSidenavModule } from '@angular/material/sidenav';
import { SideNavComponent } from './side-nav/side-nav.component';
import { FooterComponent } from './footer/footer.component';
import { MaterialModule } from './material/material.module';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { EntrepriseComponent } from './entreprise/entreprise.component';
import { DepenseComponent } from './depense/depense.component';
import { PlanningComponent } from './planning/planning.component';
import { GroupeComponent } from './groupes/groupes.component';
import { TacheComponent } from './tache/tache.component';
import { FormulaireComponent } from './formulaire/formulaire.component';
import { FormsModule } from '@angular/forms';
import { PlanninEntrepriseComponent } from './plannin-entreprise/plannin-entreprise.component';
import { PacksComponent } from './packs/packs.component';
import { EtudiantComponent } from './etudiant/etudiant.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { FeedAfficheComponent } from './feed-affiche/feed-affiche.component'; // Importez FormsModule


@NgModule({
  declarations: [AppComponent,
    LayoutComponent,
    LayoutComponent,

    HeaderComponent,
    SideNavComponent,
    FooterComponent,
    DashboardComponent,
    LoginComponent,
    RegisterComponent,


    EntrepriseComponent,
    DepenseComponent,
    PlanningComponent,

    GroupeComponent,
    TacheComponent,
    FormulaireComponent,
    PlanninEntrepriseComponent,
    PacksComponent,
    EtudiantComponent,
    FeedbackComponent,
    FeedAfficheComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatRadioModule,
    MatSelectModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatSnackBarModule,
    FormsModule,
    MatSidenavModule,
    MaterialModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule { }
