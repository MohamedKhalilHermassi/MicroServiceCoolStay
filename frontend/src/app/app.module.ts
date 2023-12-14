import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import {FormsModule} from "@angular/forms";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from "@angular/material/button";
import {HttpClientModule} from "@angular/common/http";
import { HomeComponent } from './home/home.component';
import { FormHebergementComponent } from './form-hebergement/form-hebergement.component';
import { HebergementComponent } from './hebergement/hebergement.component';
import {ToastrModule} from "ngx-toastr";
import { MesReservationsComponent } from './mes-reservations/mes-reservations.component';
import { FormReclamationComponent } from './form-reclamation/form-reclamation.component';
import { MesReclamationsComponent } from './mes-reclamations/mes-reclamations.component';

@NgModule({
  declarations: [
    AppComponent,
    SignInComponent,
    SignUpComponent,
    HomeComponent,
    FormHebergementComponent,
    HebergementComponent,
    MesReservationsComponent,
    FormReclamationComponent,
    MesReclamationsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatButtonModule,
    BrowserAnimationsModule, // required animations module
    ToastrModule.forRoot(),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
