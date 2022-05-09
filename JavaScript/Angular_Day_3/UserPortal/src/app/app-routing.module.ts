import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {RegistrationComponent} from "./pages/registration/registration.component";
import {UserListComponent} from "./pages/user-list/user-list.component";
import {LoginComponent} from "./pages/login/login.component";
import {AirportsComponent} from "./pages/airports/airports.component";

const routes: Routes = [
  {
    path: "sign-up",
    component: RegistrationComponent
  },
  {
    path: "users",
    component: UserListComponent
  },
  {
    path: "login",
    component: LoginComponent
  },
  {
    path: "airports",
    component: AirportsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
