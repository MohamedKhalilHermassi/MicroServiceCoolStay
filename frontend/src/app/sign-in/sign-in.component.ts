import { Component } from '@angular/core';
import {userCredentials} from "../shared/models/userCredentials";
import {UserService} from "../shared/service/userService/user.service";
import * as jwt_decode from 'jsonwebtoken';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.scss']
})
export class SignInComponent {
userCredentials:userCredentials = new userCredentials();
  constructor(private userService:UserService) {
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
      }
    )
    console.log(body.toString());
}
}
