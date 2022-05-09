import {Component, OnInit} from '@angular/core';
import {AirportService} from "./services/airport.service";
import {HttpClient} from "@angular/common/http";

interface Airport {
  id: string;
  city: string;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
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
    this.httpClient.get<Airport>("http://localhost:8080/Airport/ORD").subscribe(
      (data) => {
        this.city = data.city;
        this.loading = false;
      }
    );
    this.city = "something else"
  }
}
