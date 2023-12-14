import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {SignInComponent} from "./sign-in/sign-in.component";
import {SignUpComponent} from "./sign-up/sign-up.component";
import {HomeComponent} from "./home/home.component";
import {FormHebergementComponent} from "./form-hebergement/form-hebergement.component";
import {HebergementComponent} from "./hebergement/hebergement.component";
import {MesReservationsComponent} from "./mes-reservations/mes-reservations.component";
import * as path from "path";
import {FormReclamationComponent} from "./form-reclamation/form-reclamation.component";
import {MesReclamationsComponent} from "./mes-reclamations/mes-reclamations.component";

const routes: Routes = [
  {path:'', component:SignInComponent},
  {path:'sign-up', component:SignUpComponent},
  {path:'home', component:HomeComponent},
  {path:'add-hebergement', component:FormHebergementComponent},
  {path: 'get-hebergement/:id', component: HebergementComponent},
  {path: 'mes-reservations', component: MesReservationsComponent},
  {
    path:'reclamation', component: FormReclamationComponent
  },
  {
    path:'mes-reclamations',component: MesReclamationsComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
