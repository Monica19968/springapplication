import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SchedulerService {
  private baseUrl = 'http://localhost:8080/jobScheduler/';
  constructor() { }
}
