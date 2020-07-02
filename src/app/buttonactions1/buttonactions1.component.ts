import { Component, OnInit } from '@angular/core';
import { ICellRendererAngularComp } from 'ag-grid-angular';
import { ListofschedulersComponent } from '../listofschedulers/listofschedulers.component';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
@Component({
  selector: 'app-buttonactions1',
  templateUrl: './buttonactions1.component.html',
  styleUrls: ['./buttonactions1.component.css']
})
export class Buttonactions1Component implements ICellRendererAngularComp  {
  public params: any;
  rowData:any;
  userData: any;

  constructor(private modalService: NgbModal) { }
  agInit(params: any): void {
    this.params = params;
  }
  invokeDeleteMethod() {
    var selectedData = this.params.data;
    this.params.api.updateRowData({ remove: [selectedData] });
  }
  
  invokeEditViewMethod(action: any) {
    var selectedData = this.params.data;
    const modalRef = this.modalService.open(ListofschedulersComponent, {
      centered: true,
      size: 'lg',
      backdrop: 'static'
    });

    (modalRef.componentInstance as ListofschedulersComponent).data = selectedData;
    (modalRef.componentInstance as ListofschedulersComponent).action = action;
     //this.params.api.clicked({edit: [selectedData]});
    (modalRef.componentInstance as ListofschedulersComponent).savedScheduler.subscribe((entry) => {
      console.log(entry);
      this.rowData.push(entry);
      console.log(this.rowData);
    });
  }

  refresh(): boolean {
    return true;
  }
  ngOnInit(): void {
  }

}
