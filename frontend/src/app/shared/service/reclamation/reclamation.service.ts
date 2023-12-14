import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../../environments/environment.development";
import {Reclamation} from "../../models/reclamation";

@Injectable({
  providedIn: 'root'
})
export class ReclamationService {
  endPoint:String = environment.baseUrl+'reclamations';
  constructor(private http:HttpClient) { }

  addReclamation(reclamation:Reclamation) {
   return  this.http.post<Reclamation>(this.endPoint + '/add-reclamation', reclamation);
  }
}
