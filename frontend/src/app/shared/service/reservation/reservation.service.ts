import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Reservation} from "../../models/reservation";
import {environment} from "../../../../environments/environment.development";

@Injectable({
  providedIn: 'root'
})
export class ReservationService {
  endPoint:String = environment.baseUrl+'reservation';

  constructor(
      private http:HttpClient
  ) { }

  public addReservation(reservation:Reservation)
  {
   return this.http.post(this.endPoint+'/add-reservation',reservation)
  }
}
