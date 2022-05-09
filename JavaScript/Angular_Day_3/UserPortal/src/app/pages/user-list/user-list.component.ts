import { Component, OnInit } from '@angular/core';
import {User} from "../../interface/User";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
  username = "Not Found";

  constructor(private http:HttpClient) { }

  ngOnInit() {
    this.getUsers();
  }

  getUsers() {
    this.http.get<User>("http://localhost:8080/user/1").subscribe(
      (data) => {
        this.username = data.username;
      }
    );
  }

}
