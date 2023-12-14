import {Component, OnInit} from '@angular/core';
import {Hebergement} from "../shared/models/hebergement";
import {ActivatedRoute} from "@angular/router";
import {HebergementService} from "../shared/service/hebergement.service";
import {Reservation} from "../shared/models/reservation";
import {ReservationService} from "../shared/service/reservation/reservation.service";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-hebergement',
  templateUrl: './hebergement.component.html',
  styleUrls: ['./hebergement.component.scss']
})
export class HebergementComponent implements  OnInit{
  hebergement:Hebergement = new Hebergement()
  reservation:Reservation = new Reservation()
  id:number = 0;
  constructor(private _activated: ActivatedRoute,
              private serviceHebergement:HebergementService,
              private serviceReservation: ReservationService,
              private toastr: ToastrService
  ) {
  }
ngOnInit() {

  this._activated.params.subscribe((params) => {
    this.id = params['id'];
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


}
