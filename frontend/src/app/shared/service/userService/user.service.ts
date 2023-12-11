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

}
