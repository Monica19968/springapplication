import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  [x: string]: any;
  gridApi: any;
  //domLayout = "normal"; 
  // onBtnClick1: any;

  constructor(private router: Router) { }
  // home:any;
  ngOnInit(): void {
  }
  locations(): void {
    this.router.navigate(["locations"]);

  }

  onGridReady(params) {
    this.gridApi = params.api; // To access the grids API
  }
  columnDefs = [
    { field: "ID",width: 300 , editable: true, resizable: true },
    { field: "SchedulerName",width:300,  resizable: true },
    { field: "Execution_Time",width:300,  resizable: true },
    { field: "Status",width:300, resizable: true },

    {
      field: "Actions", onCellClicked: this.makeCellClicked.bind(this),
      cellRenderer: function clickNextRendererFunc() {
        return '<i class="fa fa-trash-o ml-2" data-toggle="tooltip" data-placement="bottom" title="Delete" aria-hidden="true"></i>' ;}
       }
    ];
  rowData = [
    { ID: 1, SchedulerName: "sushma", Execution_Time: "9:00AM", Status: "success", "editable": true },
    { ID: 2, SchedulerName: "gayatri", Execution_Time: "9:30AM", Status: "failed", "editable": true },
    { ID: 3, SchedulerName: "manju", Execution_Time: "9:00PM", Status: "failed", "editable": true },
    { ID: 4, SchedulerName: "raghu", Execution_Time: "10:00AM", Status: "success", "editable": true },
    { ID: 5, SchedulerName: "yamini", Execution_Time: "11:00AM", Status: "success", "editable": true },
    { ID: 6, SchedulerName: "jyoshna", Execution_Time: "12:00PM", Status: "failed", "editable": true },
    { ID: 1, SchedulerName: "sushma", Execution_Time: "9:00AM", Status: "success", "editable": true },
    { ID: 2, SchedulerName: "gayatri", Execution_Time: "9:30AM", Status: "failed", "editable": true },
    { ID: 3, SchedulerName: "manju", Execution_Time: "9:00PM", Status: "failed", "editable": true },
    { ID: 4, SchedulerName: "raghu", Execution_Time: "10:00AM", Status: "success", "editable": true },
    { ID: 5, SchedulerName: "yamini", Execution_Time: "11:00AM", Status: "success", "editable": true },
    { ID: 6, SchedulerName: "jyoshna", Execution_Time: "12:00PM", Status: "failed", "editable": true }
  ];



  makeCellClicked(e: any): void {
    for (let i = 0; i < this.rowData.length; ++i) {
      if (this.rowData[i].ID === e.data.ID) {
        this.rowData.splice(i, 1);
      }
    }
    this.gridApi.setRowData(this.rowData);


  }
  
}
