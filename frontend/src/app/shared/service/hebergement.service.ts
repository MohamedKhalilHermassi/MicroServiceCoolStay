import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Environment} from "@angular/cli/lib/config/workspace-schema";
import {environment} from "../../../environments/environment.development";
import {Hebergement} from "../models/hebergement";
import {Observable} from "rxjs";
import {HebergementWithRecommendations} from "../models/HebergementWithRecommendations";

@Injectable({
  providedIn: 'root'
})
export class HebergementService {
  endPoint:String = environment.baseUrl+'hebergement';
  constructor(private http:HttpClient) { }

 public addHebergement(hebergement:Hebergement)
  {
  return   this.http.post(this.endPoint+'/add-hebergement',hebergement);
  }

  public getAllHebergement()
  {
      return this.http.get(this.endPoint+'/get-all');
  }

  public getHebergementbyId(id:number)
  {
      return this.http.get(this.endPoint+'/get-by-id/'+id)
  }

  public getHebergementWithRecommendation(id:number)
  {
    return this.http.get<HebergementWithRecommendations>(this.endPoint+'/with-recommandation/'+id);

  }
}
