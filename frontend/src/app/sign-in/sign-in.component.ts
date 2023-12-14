import { Component } from '@angular/core';
import {userCredentials} from "../shared/models/userCredentials";
import {UserService} from "../shared/service/userService/user.service";
import * as jwt_decode from 'jsonwebtoken';
import {Router} from "@angular/router";
import {UserMS} from "../shared/models/userMS";


@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.scss']
})
export class SignInComponent {
userCredentials:userCredentials = new userCredentials();
userMS:UserMS = new UserMS();
  constructor(private userService:UserService,
  private router:Router
  ) {
  }
  onSubmit(){
    const body = new URLSearchParams();
    body.set('username', this.userCredentials.username);
    body.set('password', this.userCredentials.password);
    body.set('client_id', 'microservices-app');
    body.set('client_secret', '3pUynp3KH9CntVGx7NoLFTizeMbiSmOf');
    body.set('grant_type', 'password');

    this.userService.getToken( this.userCredentials.username, this.userCredentials.password,'microservices-app','3pUynp3KH9CntVGx7NoLFTizeMbiSmOf').subscribe(

      (res)=>{

        const token:string = res.access_token

        const jwtToken = token; // Replace this with your actual JWT

// Split the JWT into header, payload, and signature (if present)
        const [headerEncoded, payloadEncoded] = jwtToken.split('.');

// Decode the header and payload using base64 decoding
        const decodedHeader = atob(headerEncoded);
        const decodedPayload = atob(payloadEncoded);

// Parse the decoded header and payload as JSON
        const parsedHeader = JSON.parse(decodedHeader);
        const parsedPayload = JSON.parse(decodedPayload);

        console.log('Decoded Header:', parsedHeader);
        console.log('Decoded Payload:', parsedPayload);


        console.log(token);
        console.log(res);


        if (token!=null)
        {
          localStorage.setItem('username',parsedPayload.preferred_username);
          localStorage.setItem('email',parsedPayload.email)
          localStorage.setItem('family-name',parsedPayload.family_name)
          localStorage.setItem('token',token)

          this.userService.getMyFullInfo(parsedPayload.preferred_username).subscribe(
            (res)=>{
              this.userMS = res;
              localStorage.setItem('my-H2-id',this.userMS.id.toString())
              console.log(this.userMS)
            }
          )


          this.router.navigate(["/home"]);





        }
        else
        {

        }



        // Store token in LocalStorage




      }
    )
    console.log(body.toString());
}
}
