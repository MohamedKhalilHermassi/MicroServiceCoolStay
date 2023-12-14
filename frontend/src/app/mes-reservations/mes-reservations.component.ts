import {Component, OnInit} from '@angular/core';
import {UserWithReservation} from "../shared/models/userWithReservation";
import {ReservationService} from "../shared/service/reservation/reservation.service";
import {UserService} from "../shared/service/userService/user.service";

@Component({
  selector: 'app-mes-reservations',
  templateUrl: './mes-reservations.component.html',
  styleUrls: ['./mes-reservations.component.scss']
})
export class MesReservationsComponent implements OnInit{
userWithReservaton:UserWithReservation = new UserWithReservation()

constructor(private serviceUser: UserService) {
}

ngOnInit() {
  this.serviceUser.getmyReservation(Number(localStorage.getItem('my-H2-id'))).subscribe(
      (res)=>{
        this.userWithReservaton=res;
        console.log(res)
      }
  )
}


}
