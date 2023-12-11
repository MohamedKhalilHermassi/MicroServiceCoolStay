import { Component } from '@angular/core';
import {UserMS} from "../shared/models/userMS";
import {UserService} from "../shared/service/userService/user.service";

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent {
  user:UserMS = new UserMS();

  constructor(private userService:UserService) {
  }

  onSubmit() {
    console.log(this.user);
    this.userService.addUser(this.user).subscribe((res) => {

      console.log(res);
    })
  }
}
