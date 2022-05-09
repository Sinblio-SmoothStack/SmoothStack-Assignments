import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavigationBarComponent } from './nav-bar/navigation-bar.component';
import { RegistrationComponent } from './pages/registration/registration.component';
import { UserListComponent } from './pages/user-list/user-list.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from "@angular/common/http";
import { LoginComponent } from './pages/login/login.component';
import { AirportsComponent } from './pages/airports/airports.component';

@NgModule({
  declarations: [
    AppComponent,
    NavigationBarComponent,
    RegistrationComponent,
    UserListComponent,
    LoginComponent,
    AirportsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
