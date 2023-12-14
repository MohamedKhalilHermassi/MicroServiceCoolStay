import {Component, OnInit} from '@angular/core';
import {UserWithReclamation} from "../shared/models/userWithReclamation";
import {UserService} from "../shared/service/userService/user.service";

@Component({
  selector: 'app-mes-reclamations',
  templateUrl: './mes-reclamations.component.html',
  styleUrls: ['./mes-reclamations.component.scss']
})
export class MesReclamationsComponent implements OnInit{
userWithReclamation:UserWithReclamation = new UserWithReclamation()

constructor(private userService : UserService) {

}
ngOnInit() {

  this.userService.getMyReclamations(Number(localStorage.getItem('my-H2-id'))).subscribe(
      (res)=>{
        console.log(res)
        this.userWithReclamation=res;
      }
  )

}


}
