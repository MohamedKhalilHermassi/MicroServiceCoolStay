import { Component } from '@angular/core';
import {Hebergement} from "../shared/models/hebergement";
import {HebergementService} from "../shared/service/hebergement.service";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-form-hebergement',
  templateUrl: './form-hebergement.component.html',
  styleUrls: ['./form-hebergement.component.scss']
})
export class FormHebergementComponent {
hebergement:Hebergement = new Hebergement()
constructor(private serviceHebergement:HebergementService,
            private toastr: ToastrService) {
}
    onSubmit(){

        this.serviceHebergement.addHebergement(this.hebergement).subscribe(
            (res)=> {
                console.log(res)
                this.toastr.success('Hébéregement ajoutée avec succès', 'Succès');
            }
        )

        console.log(this.hebergement)

    }
}
