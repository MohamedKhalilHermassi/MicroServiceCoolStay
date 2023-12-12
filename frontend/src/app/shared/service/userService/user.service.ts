import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {environment} from "../../../../environments/environment.development";
import {UserMS} from "../../models/userMS";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  endPoint:String = environment.baseUrl+'users';

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

}
