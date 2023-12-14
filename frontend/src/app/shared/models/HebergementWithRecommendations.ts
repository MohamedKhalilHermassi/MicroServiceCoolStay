import {Recommendation} from "./recommendation";

export class HebergementWithRecommendations {
  id!: number;
  adresse!:string;
  libelle!: string;
  nom!: string;
  capacite!: number;
  prix!: number;
  recommendations!: Recommendation[]

}
