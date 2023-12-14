import { Component } from '@angular/core';
import {UserMS} from "../shared/models/userMS";
import {UserService} from "../shared/service/userService/user.service";
import {Toast, ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent {
  user:UserMS = new UserMS();

  constructor(private userService:UserService,
  private toastr:ToastrService
  ) {
  }

  onSubmit() {
    console.log(this.user);
    this.userService.addUser(this.user).subscribe((res) => {
      console.log(res);
this.toastr.success("Votre compte a été créé avec succes","Succès",)
    })
  }
}
