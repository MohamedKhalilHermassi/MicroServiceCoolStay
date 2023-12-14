import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MesReservationsComponent } from './mes-reservations.component';

describe('MesReservationsComponent', () => {
  let component: MesReservationsComponent;
  let fixture: ComponentFixture<MesReservationsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MesReservationsComponent]
    });
    fixture = TestBed.createComponent(MesReservationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
