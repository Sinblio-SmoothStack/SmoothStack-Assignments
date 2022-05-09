import { Injectable } from '@angular/core';
import { HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Airport} from "../interfaces/airport";

@Injectable({
  providedIn: 'root'
})
export class AirportService {

  constructor(private httpClient: HttpClient) { }

  getAirport(): Observable<Airport> {
    return this.httpClient.get<Airport>("http://localhost:8080/Airport/ORD")
  }
}
