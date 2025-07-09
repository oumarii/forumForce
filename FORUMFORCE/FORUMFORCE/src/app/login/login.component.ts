import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms'; // Importez FormsModule
import { Login1Service } from '../services/login1.service';


import { Router } from '@angular/router';
import { Observable } from 'rxjs';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  passss: any;
  username: any;

  log$!: any;

  constructor(private ss: Login1Service, private router: Router) {
    this.log$ = ss.admiin();

  }
  ngOnInit(): void {
    this.ss.admiin().subscribe(
      (data) => {
        this.log$ = data;
        console.log(this.log$);
      },
    );
  }

  login() {

    if ((this.log$.login == this.username) && (this.log$.motDePasse == this.passss)) {
      alert('Login Succesful');
      this.router.navigate(["/site/dashboard/"])
    }
    else {
      alert('Verifier vos donnees');
    }
  }
  formulaire() {
    this.router.navigate(['/formulaire'])

  }
}
