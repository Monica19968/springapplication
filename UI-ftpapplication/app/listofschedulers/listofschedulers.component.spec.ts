import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListofschedulersComponent } from './listofschedulers.component';

describe('ListofschedulersComponent', () => {
  let component: ListofschedulersComponent;
  let fixture: ComponentFixture<ListofschedulersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListofschedulersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListofschedulersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
