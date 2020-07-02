import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ButtonactionsComponent } from './buttonactions.component';

describe('ButtonactionsComponent', () => {
  let component: ButtonactionsComponent;
  let fixture: ComponentFixture<ButtonactionsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ButtonactionsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ButtonactionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
