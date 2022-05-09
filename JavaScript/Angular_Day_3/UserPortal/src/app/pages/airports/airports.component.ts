import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Airport} from "../../interface/Airport";
import {User} from "../../interface/User";

@Component({
  selector: 'app-airports',
  templateUrl: './airports.component.html',
  styleUrls: ['./airports.component.css']
})
export class AirportsComponent implements OnInit {
  airports: Airport[] | undefined;

  newAirport: Airport | undefined;

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
    getAirports();
  }

  getAirports() {
    this.http.get<Airport[]>("http://localhost:8080/user/1").subscribe(
      (data) => {
        this.airports = data;
      }
    );
  }

  addAirport() {
    this.http.post<Airport[]>("http://localhost:8080/user/1").subscribe(
      (data) => {
        this.airports = data;
      }
    );
  }

}
