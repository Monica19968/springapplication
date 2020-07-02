import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, } from '@ng-bootstrap/ng-bootstrap';
import { ListofschedulersComponent } from '../listofschedulers/listofschedulers.component';
import { Buttonactions1Component } from '../buttonactions1/buttonactions1.component';
@Component({
  selector: 'app-scheduler',
  templateUrl: './scheduler.component.html',
  styleUrls: ['./scheduler.component.css']
})
export class SchedulerComponent implements OnInit {
  gridApi: any;
  frameworkComponents: any;
  dialog: any;
  // gridApi: any;
  // gridColumnApi:any;
  columnDefs: any;
  rowData: any;
  userData: any;
  //  frameworkComponents:any;
  context: any;
  gridColumnApi: any;
  onGridReady(params) {
    this.gridApi = params.api; // To access the grids API
    this.gridColumnApi = params.columnApi;
  }
  constructor(private router: Router, public modalService: NgbModal) {
    // console.log(this.userData);
  }
  ngOnInit(): void {
    this.frameworkComponents = {
      Buttonactions1Component: Buttonactions1Component
    };
    this.context = { componentParent: this };

    this.columnDefs = [
      { field: "ID", editable: true, resizable: true, width: 200,sortable: true,filter: true },
      { field: "schedulerName", editable: true, resizable: true, width: 250,sortable: true,filter: true },
      { field: "Actions", cellRenderer: 'Buttonactions1Component', resizable: true, width: 250,sortable: true,filter: true }

    ];
    this.rowData = [
      { ID: 2063, SchedulerName: "sushma", sourceLocation: 'Location1', destinationLocation: 'Location5', hour: '12', minute: '30', frequency: 'Daily' },
      { ID: 2072, SchedulerName: "divija", sourceLocation: 'Location2', destinationLocation: 'Location6', hour: '12', minute: '30', frequency: 'Daily' },
      { ID: 2071, SchedulerName: "monica", sourceLocation: 'Location3', destinationLocation: 'Location3', hour: '12', minute: '30', frequency: 'Daily' },
      { ID: 2070, SchedulerName: "jhanavi", sourceLocation: 'Location4', destinationLocation: 'Location8', hour: '12', minute: '30', frequency: 'Daily'},
      { ID: 2061, SchedulerName: "gayatri",sourceLocation: 'Location1', destinationLocation: 'Location5', hour: '12', minute: '30', frequency: 'Daily'},
      { ID: 22, SchedulerName: "heya",sourceLocation: 'Location2', destinationLocation: 'Location6', hour: '11', minute: '30', frequency: 'Daily'},
      { ID: 21, SchedulerName: "vicky",sourceLocation: 'Location3', destinationLocation: 'Location3', hour: '9', minute: '30', frequency: 'Daily'},
      { ID: 20, SchedulerName: "manju",sourceLocation: 'Location4', destinationLocation: 'Location8', hour: '10', minute: '30', frequency: 'Daily'}

    ];
    
  }
  listofschedulers(): void {
    this.router.navigate(["listofschedulers"]);
  }



  // makeCellClicked(e: any): void {
  //   for (let i = 0; i < this.rowData.length; ++i) {
  //     if (this.rowData[i].ID === e.data.ID) {
  //       this.rowData.splice(i, 1);
  //     }
  //   }
  //   this.gridApi.setRowData(this.rowData);


  // }



  openComp() {
    this.modalService.open(ListofschedulersComponent, {
      centered: true,
      size: 'lg',
      backdrop: 'static',
    });
  }
}
