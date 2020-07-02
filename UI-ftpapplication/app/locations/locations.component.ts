import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ListoflocationsComponent } from '../listoflocations/listoflocations.component';
import { ButtonactionsComponent } from '../buttonactions/buttonactions.component';
@Component({
  selector: 'app-locations',
  templateUrl: './locations.component.html',
  styleUrls: ['./locations.component.css']
})
export class LocationsComponent implements OnInit {
  dialog: any;
  gridApi: any;
  gridColumnApi:any;
   columnDefs:any;
   rowData:any;
   frameworkComponents:any;
   context:any;
  onGridReady(params) {
    this.gridApi = params.api; // To access the grids API
    this.gridColumnApi = params.columnApi;
  }
  constructor(private router: Router,private modalService: NgbModal) { }

  ngOnInit(): void {
    this.frameworkComponents = {
      ButtonactionsComponent: ButtonactionsComponent
    };

    this.context = { componentParent: this };
  
  




 this.columnDefs = [
    { field: "ID", editable: true, resizable: true,width: 250,sortable: true,filter: true},
    {field: "LocationName", editable: true,width: 250,sortable: true,filter: true},
    {field: "Actions", cellRenderer: 'ButtonactionsComponent',width: 250,sortable: true,filter: true}
    // onCellClicked: this.makeCellClicked.bind(this),
    //   cellRenderer: function clickNextRendererFunc() {
    //     return '<button class="btn btn-primary">Delete</button>';
        

    
  ];
  this.rowData = [
    { ID: 3424, LocationName: "Location1",ftpLocationUrl: "./osi/sushma", UserName: "admin", Password: "admin" },
    { ID: 7865, LocationName: "Location2" ,ftpLocationUrl: "./osi/gayatri", UserName: "admin", Password: "admin"},    
    { ID: 2063, LocationName: "Location3",ftpLocationUrl: "./osi/abhi", UserName: "admin", Password: "admin" },
    { ID: 2060, LocationName: "Location4",ftpLocationUrl: "./osi/manju", UserName: "admin", Password: "admin" },
    { ID: 2059, LocationName: "Location5",ftpLocationUrl: "./osi/raghu", UserName: "admin", Password: "admin" },
    { ID: 2061, LocationName: "Location6",ftpLocationUrl: "./osi/raju", UserName: "admin", Password: "admin" }
  ];
}
  // Location1 = [
  //   { sno: 1, SchdulerName: "my_home" }
  // ];
  createlocation(): void {
    this.router.navigate(["createlocation"]);
  }
  
  
  

  // makeCellClicked(e: any): void {
  //   for (let i = 0; i < this.rowData.length; ++i) {
  //     if (this.rowData[i].ID === e.data.ID) {
  //       this.rowData.splice(i, 1);
  //     }
  //   }
  //   this.gridApi.setRowData(this.rowData);


  // }
  // makeCellClicked1(e: any): void {
    

  // }
  openComp() {
    this.modalService.open( ListoflocationsComponent, {
      centered: true,
      size: 'lg',
      backdrop: 'static',
    });
  }
  listoflocations(): void {
    this.router.navigate(["listoflocations"]);
  }
}
