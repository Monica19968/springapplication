import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule, NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { AgGridModule } from 'ag-grid-angular';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { LocationsComponent } from './locations/locations.component';
import { ListoflocationsComponent } from './listoflocations/listoflocations.component';
import { SchedulerComponent } from './scheduler/scheduler.component';
import { ListofschedulersComponent } from './listofschedulers/listofschedulers.component';
import { ButtonactionsComponent } from './buttonactions/buttonactions.component';
import { Buttonactions1Component } from './buttonactions1/buttonactions1.component';
import { HttpClientModule } from '@angular/common/http';  
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    LocationsComponent,
    ListoflocationsComponent,
    SchedulerComponent,
    ListofschedulersComponent,
    ButtonactionsComponent,
    Buttonactions1Component
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    NgbModule,
    HttpClientModule,
    AgGridModule.withComponents([ButtonactionsComponent,Buttonactions1Component])
  ],
  entryComponents: [
    ListofschedulersComponent,ListoflocationsComponent
  ],
  providers: [NgbModule,NgbActiveModal],
  bootstrap: [AppComponent]
})
export class AppModule { }
