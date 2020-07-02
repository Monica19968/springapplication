import { Directive, ElementRef, HostListener } from '@angular/core';
import { NG_VALIDATORS, Validator, AbstractControl } from '@angular/forms';

@Directive({
  selector: '[appNameValidator]',
  providers: [{
    provide: NG_VALIDATORS,
    useExisting: NameValidatorDirective,
    multi: true
  }]
})
export class NameValidatorDirective implements Validator {

  constructor(private elementRef: ElementRef) { }
 
 @HostListener('mouseover') onmouseover(): any {
 const el = this.elementRef.nativeElement;
 el.style.color = 'blue';
 el.style.background = 'red';
 }
 
 @HostListener('mouseout') onmouseout(): any {
 const el = this.elementRef.nativeElement;
 el.style.color = 'black';
 el.style.background = 'white';
 }

  validate(control: AbstractControl): any {
    if (control.value) {
      return control.value.match(/^[a-zA-Z]+$/) ? null : { 'alphabet': true };
    }

}
}
