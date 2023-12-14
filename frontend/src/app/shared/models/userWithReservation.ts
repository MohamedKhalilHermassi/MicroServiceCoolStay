import {Reservation} from "./reservation";

export class UserWithReservation {
    id!: number;
    username!:string;
    firstName!: string;
    lastName!: string;
    password!: string;
    email!: string;
    reservations!: Reservation[];
}
