import {Component, OnInit} from '@angular/core';
import {Hebergement} from "../shared/models/hebergement";
import {ActivatedRoute} from "@angular/router";
import {HebergementService} from "../shared/service/hebergement.service";
import {Reservation} from "../shared/models/reservation";
import {ReservationService} from "../shared/service/reservation/reservation.service";
import {ToastrService} from "ngx-toastr";
import {Recommendation} from "../shared/models/recommendation";
import {RecommmendationService} from "../shared/service/recommendation/recommmendation.service";
import {HebergementWithRecommendations} from "../shared/models/HebergementWithRecommendations";

@Component({
  selector: 'app-hebergement',
  templateUrl: './hebergement.component.html',
  styleUrls: ['./hebergement.component.scss']
})
export class HebergementComponent implements  OnInit{
  hebergement:Hebergement = new Hebergement()
  recommendation:Recommendation = new Recommendation()
  reservation:Reservation = new Reservation()
  hebergementWithRecommendation:HebergementWithRecommendations = new HebergementWithRecommendations()

  id:number = 0;
  constructor(private _activated: ActivatedRoute,
              private serviceHebergement:HebergementService,
              private serviceReservation: ReservationService,
              private toastr: ToastrService,
              private serviceRecommendation:RecommmendationService,
  ) {
  }
ngOnInit() {

  this._activated.params.subscribe((params) => {
    this.id = params['id'];
    this.serviceHebergement.getHebergementWithRecommendation(this.id).subscribe(
      (val)=>{
        this.hebergementWithRecommendation=val
        console.log(this.hebergementWithRecommendation.recommendations)
      }
    )

    this.serviceHebergement.getHebergementbyId(this.id).subscribe((res) => {
      this.hebergement = res as Hebergement;
    })
  })
}

onSubmit(){
    console.log(this.reservation)
  this.reservation.userId=localStorage.getItem('my-H2-id')
  this.reservation.hebergementId=this.id
    this.serviceReservation.addReservation(this.reservation).subscribe(
        (res)=> {
          console.log(res)
          this.toastr.success('Réservation ajoutée avec succès', 'Succès');
        }
    )
}



  onSumbitComment() {
    this.recommendation.userId = Number(localStorage.getItem('my-H2-id'));
    this.recommendation.idHebergement = Number(this.id);
    this.recommendation.auteur = String(localStorage.getItem('username'));

    console.log(this.recommendation);

    this.serviceRecommendation.addRecommendation(this.recommendation).subscribe(
      (res) => {
        console.log(res);

        this.serviceHebergement.getHebergementWithRecommendation(this.id).subscribe(
          (val) => {
            this.hebergementWithRecommendation = val as HebergementWithRecommendations;
            console.log(this.hebergementWithRecommendation.recommendations);
          }
        );
      }
    );
  }

}
