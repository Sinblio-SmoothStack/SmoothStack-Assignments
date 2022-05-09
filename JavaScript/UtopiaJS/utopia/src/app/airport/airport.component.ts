import { Component, OnInit } from '@angular/core';
import {AirportService} from "../services/airport.service";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-airport',
  templateUrl: './airport.component.html',
  styleUrls: ['./airport.component.css']
})
export class AirportComponent implements OnInit {
  city = "";
  loading = true;
  airportService: AirportService;


  constructor(private httpClient: HttpClient) {
    this.airportService = new AirportService(httpClient);
  }

  ngOnInit(): void {
    this.loadAirport();
  }

  loadAirport() {
    this.loading = true;
    this.airportService.getAirport().subscribe(
      (data) => {
        this.city = data.city;
        this.loading = false;
      }
    );
    this.city = "something else"
  }

}
