import { Component, OnInit,Input } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Location } from '../location';  
import { LocationService } from './location.service';
@Component({
  selector: 'app-listoflocations',
  templateUrl: './listoflocations.component.html',
  styleUrls: ['./listoflocations.component.css']
})
export class ListoflocationsComponent implements OnInit {
  @Input() public data;
  @Input() public action;
  title: any;
  formValue = false;
 location : Location=new Location(); 
  locationForm = new FormGroup({
    locationName: new FormControl('', Validators.required),
    ftpLocationUrl: new FormControl('', Validators.required),
    userName: new FormControl('', Validators.required),
    // id: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required)
  });
 // Id: any;
 // Password: any;
  constructor(public activeModal: NgbActiveModal,private locationservice:LocationService) { }

  ngOnInit(): void {
    if (this.data) {
      this.locationForm.patchValue({
        locationName: this.data.LocationName,
        ftpLocationUrl: this.data.ftpLocationUrl,
        userName: this.data.UserName,
        // id: this.data.Id,
        password: this.data.Password,
        
      });
    }
    if (this.action) {
      this.title = this.action + ' Location';
    } else {
      this.title = 'Create Location';
    }
    if (this.action === 'View') {
      this.locationForm.disable();
      this.formValue = true;
    }
  }
  

  
    onSubmit() {
      this.location=new Location();     
    this.location.locationName= this.LocationName.value;  
    this.location.ftpLocationUrl=this.FtpLocationUrl.value;  
    this.location.userName= this.UserName.value;  
    // this.location.id= this.Id.value;  
    this.location.password=this.Password.value;
    this.formValue = true;  
    this.save(); 
      console.log(this.locationForm.value);
    }


    save() {  
      this.locationservice.createFTPLocation(this.location)  
        .subscribe(location1 => console.log(location1), error => console.log(error));  
      this.location = new Location();  
    }  
 get LocationName(){  
    return this.locationForm.get('locationName');  
  }  
  
  get FtpLocationUrl(){  
    return this.locationForm.get('ftpLocationUrl');  
  }  
  
  get UserName(){  
    return this.locationForm.get('userName');  
  }
  // get Id(){  
  //   return this.locationForm.get('id');  
  // }    
  get Password(){  
    return this.locationForm.get('password');  
  }  
  addLocationForm(){
    this.formValue=false;  
    this.locationForm.reset();  
  }  
  // invokeEditViewMethod(id: number){  
  //   this.studentservice.getStudent(id)  
  //     .subscribe(  
  //       data => {  
  //         this.studentlist=data             
  //       },  
  //       error => console.log(error));  
  // }  
  }
  


