import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Buttonactions1Component } from './buttonactions1.component';

describe('Buttonactions1Component', () => {
  let component: Buttonactions1Component;
  let fixture: ComponentFixture<Buttonactions1Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Buttonactions1Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Buttonactions1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
