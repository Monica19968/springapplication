import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from './login/login.component';
import {HomeComponent} from './home/home.component';
import {LocationsComponent} from './locations/locations.component';
import {SchedulerComponent} from './scheduler/scheduler.component';
import {ListoflocationsComponent} from './listoflocations/listoflocations.component';
import {ListofschedulersComponent} from './listofschedulers/listofschedulers.component';
import { ButtonactionsComponent } from './buttonactions/buttonactions.component';
import { Buttonactions1Component } from './buttonactions1/buttonactions1.component';

const routes: Routes = [
  { path: '', pathMatch:"full", redirectTo:"login" },
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'locations', component: LocationsComponent },
  { path: 'listoflocations', component: ListoflocationsComponent },
  { path: 'scheduler', component: SchedulerComponent },
  { path: 'listofschedulers', component: ListofschedulersComponent },
  { path: 'buttonactions', component: ButtonactionsComponent },
  { path: 'buttonactions1', component: Buttonactions1Component }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
