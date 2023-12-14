import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../../environments/environment.development";
import {Recommendation} from "../../models/recommendation";

@Injectable({
  providedIn: 'root'
})
export class RecommmendationService {
  endPoint:String = environment.baseUrl+'recommandations';

  constructor(
    private http:HttpClient

  ) { }

  public addRecommendation(recommendation:Recommendation)
  {
    return this.http.post(this.endPoint+'/ajouter-recommandation',recommendation)
  }


}
