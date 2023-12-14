import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormReclamationComponent } from './form-reclamation.component';

describe('FormReclamationComponent', () => {
  let component: FormReclamationComponent;
  let fixture: ComponentFixture<FormReclamationComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FormReclamationComponent]
    });
    fixture = TestBed.createComponent(FormReclamationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
