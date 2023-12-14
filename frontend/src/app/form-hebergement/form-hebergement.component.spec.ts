import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormHebergementComponent } from './form-hebergement.component';

describe('FormHebergementComponent', () => {
  let component: FormHebergementComponent;
  let fixture: ComponentFixture<FormHebergementComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FormHebergementComponent]
    });
    fixture = TestBed.createComponent(FormHebergementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
