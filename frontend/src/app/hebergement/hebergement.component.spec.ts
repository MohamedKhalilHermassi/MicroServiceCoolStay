import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HebergementComponent } from './hebergement.component';

describe('HebergementComponent', () => {
  let component: HebergementComponent;
  let fixture: ComponentFixture<HebergementComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HebergementComponent]
    });
    fixture = TestBed.createComponent(HebergementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
