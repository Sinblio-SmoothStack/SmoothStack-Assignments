import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {User} from "../../interface/User";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  message = ""
  username = "";
  password = "";

  constructor(private http:HttpClient) { }

  ngOnInit() {}

  login() {
    this.http.request("GET","http://" + this.username + ":" + this.password + "@localhost:8761/hello", {responseType:"text"}).subscribe(
      (data) => {
        this.message = data;
      }
    );
  }

}
