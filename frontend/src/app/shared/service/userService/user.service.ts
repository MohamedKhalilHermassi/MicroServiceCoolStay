import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {environment} from "../../../../environments/environment.development";
import {UserMS} from "../../models/userMS";
import * as http from "http";
import {UserWithReservation} from "../../models/userWithReservation";
import {UserWithReclamation} from "../../models/userWithReclamation";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  endPoint:String = environment.baseUrl+'users';
  httpOptionsGET = {};

  constructor(private http:HttpClient) { }

  public addUser(user:UserMS){

    return this.http.post(this.endPoint+'/add-user',user);

  }

  private keycloakTokenUrl = 'http://localhost:9090/realms/SpringbootKeycloak/protocol/openid-connect/token';


  getToken(username: string, password: string, clientId: string, clientSecret: string) {
    const body = new URLSearchParams();
    body.set('username', username);
    body.set('password', password);
    body.set('client_id', clientId);
    body.set('client_secret', clientSecret);
    body.set('grant_type', 'password');

    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/x-www-form-urlencoded'
      })
    };

    return this.http.post<any>(this.keycloakTokenUrl, body.toString(), httpOptions);
  }



 public getMyFullInfo(firstname:string)
  {

    this.httpOptionsGET = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${localStorage.getItem('token')}`
      })
    };
  console.log(this.httpOptionsGET)
  return this.http.get<UserMS>('http://localhost:8182/users/get-my-info/'+firstname);
  }

  public getmyReservation(id:number)
  {
    return this.http.get<UserWithReservation>(this.endPoint+'/with-reservation/'+id)
  }

  public getMyReclamations(id:number)
  {
      return this.http.get<UserWithReclamation>(this.endPoint+'/with-reclamation/'+id);
  }
}
