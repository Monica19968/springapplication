import { Component } from '@angular/core';
import { ICellRendererAngularComp } from 'ag-grid-angular';
import { ListoflocationsComponent } from '../listoflocations/listoflocations.component';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { FormGroup, FormControl } from '@angular/forms';
@Component({
  selector: 'app-buttonactions',
  templateUrl: './buttonactions.component.html',
  styleUrls: ['./buttonactions.component.css']
})
export class ButtonactionsComponent implements ICellRendererAngularComp {
  public params: any;
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
    const modalRef = this.modalService.open(ListoflocationsComponent, {
      centered: true,
      size: 'lg',
      backdrop: 'static'
    });

    (modalRef.componentInstance as ListoflocationsComponent).data = selectedData;
    (modalRef.componentInstance as ListoflocationsComponent).action = action;
    // this.params.api.clicked({edit: [selectedData]});
  }



  refresh(): boolean {
    return true;
  }
  ngOnInit(): void {
  }
  locationForm=new FormGroup({  
    locationName:new FormControl(),  
    ftpLocationUrl:new FormControl(),  
    userName:new FormControl(),
    id:new FormControl(), 
    password:new FormControl()  
  });  
  //  invokeEditViewMethod(id: number ,action:any){  
  //   this.studentservice.getStudent(id)  
  //     .subscribe(  
  //       data => {  
  //         this.studentlist=data             
  //       },  
  //       error => console.log(error));  
  // }  
}
