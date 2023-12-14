import {Reclamation} from "./reclamation";

export class UserWithReclamation {
    id!: number;
    username!:string;
    firstName!: string;
    lastName!: string;
    password!: string;
    email!: string;
    reclamations!: Reclamation[];
}
