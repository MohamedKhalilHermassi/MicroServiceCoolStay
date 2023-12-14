import { Component } from '@angular/core';
import {Reclamation} from "../shared/models/reclamation";
import {ReclamationService} from "../shared/service/reclamation/reclamation.service";
import {ToastrService} from "ngx-toastr";


@Component({
  selector: 'app-form-reclamation',
  templateUrl: './form-reclamation.component.html',
  styleUrls: ['./form-reclamation.component.scss']
})
export class FormReclamationComponent {
reclamation:Reclamation = new Reclamation()

constructor(private serviceRclamation:ReclamationService,
            private toastr: ToastrService) {
}


onSubmit(){
  this.reclamation.userId=Number(localStorage.getItem('my-H2-id'));
  this.reclamation.status=false;
  this.serviceRclamation.addReclamation(this.reclamation).subscribe(
      (res)=>{
        console.log(res)
        this.reclamation=res;
        this.toastr.success('Réclamation ajoutée avec succès', 'Succès');

      }

  )
}


}
