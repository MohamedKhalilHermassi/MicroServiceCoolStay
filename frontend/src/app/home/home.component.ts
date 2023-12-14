import {Component, OnInit} from '@angular/core';
import {HebergementService} from "../shared/service/hebergement.service";
import {Hebergement} from "../shared/models/hebergement";
import {Route, Router} from "@angular/router";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit{
  listHebergement:Hebergement[]=[]
  constructor(private serviceHebergement:HebergementService,
              private router:Router) {
  }
  ngOnInit() {
    this.serviceHebergement.getAllHebergement().subscribe(
        (res)=>{
          this.listHebergement = res as Hebergement[]
          console.log(res)
        }
    )
  }
    signout(){
      localStorage.clear()
        this.router.navigate(['/'])
    }
  nom:string = localStorage.getItem("username")!.toString();
}
