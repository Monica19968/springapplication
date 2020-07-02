import { Component, OnInit,Input, Output, EventEmitter } from '@angular/core';
import { FormGroup, FormControl, Validators} from '@angular/forms';
import {NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Scheduler } from '../scheduler';  
import { SchedulerService } from './scheduler.service';
@Component({
  selector: 'app-listofschedulers',
  templateUrl: './listofschedulers.component.html',
  styleUrls: ['./listofschedulers.component.css']
})
export class ListofschedulersComponent implements OnInit {
  
  @Input() public data;
  @Input() public action;
  @Output() readonly savedScheduler: EventEmitter<any> = new EventEmitter();
  formValue = false;
  title: any;
 // scheduleForm: FormGroup;
  time = { hour: 12, minute: 30 };
  meridian = true;
  spinners = false;
  scheduler:Scheduler=new Scheduler();
  scheduleForm = new FormGroup({
    schedulerName: new FormControl('',Validators.required),
    sourceLocation: new FormControl('',Validators.required),
    destinationLocation: new FormControl('',Validators.required),
    frequency: new FormControl('Daily',Validators.required),
    time: new FormControl(this.time),
  });
  sourceLocation: { id: string; name: string; }[];
  destinationLocation: { id: string; name: string; }[];
  frequency: { name: string; }[];
  
  constructor(public activeModal: NgbActiveModal,private schedulerService:SchedulerService) {
    
   }

  ngOnInit(): void {
   this. sourceLocation  = [
      { id: "1", name: "Location1" },
      { id: "2", name: "Location2" },
      { id: "3", name: "Location3" }
    ];
   this. destinationLocation = [
      { id: "4", name: "Location4" },
      { id: "5", name: "Location5" },
      { id: "6", name: "Location6" }
    ];
    this.frequency = [
      { name: "Daily" },
      { name: "Weekly" },
      { name: "Monthly" }
    ]
    if (this.data) {
      this.data.time = { hour: this.data.hour, minute: this.data.minute }
      this.scheduleForm.patchValue({
        schedulerName: this.data.SchedulerName,
        sourceLocation: this.data.sourceLocation,
        destinationLocation: this.data.destinationLocation,
        frequency: this.data.frequency,
        time: this.data.Time,
      });
    }
    if (this.action) {
      this.title = this.action + ' Scheduler';
    } else {
      this.title = 'Create Scheduler';
    }
    if (this.action === 'View') {
      this.scheduleForm.disable();
      this.formValue = true;
    }
  }
  
  
  onSubmit() {
    // this.scheduler=new Scheduler();     
    // this.scheduler.schedulerName= this.schedulerName.value;  
    // this.scheduler.sourceLocation=this.sourceLocation.value;  
    // this.scheduler.destinationLocation= this.destinationLocation.value;  
    // // this.location.id= this.Id.value;  
    // this.scheduler.password=this.Password.value;
    // this.formValue = true;  
    // this.save(); 
   this.savedScheduler.emit(this.scheduleForm.value);
   //this.activeModal.close(this.scheduleForm.value);
   console.log(this.scheduleForm.value);
  }

}
