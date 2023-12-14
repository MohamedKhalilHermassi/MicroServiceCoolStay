import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MesReclamationsComponent } from './mes-reclamations.component';

describe('MesReclamationsComponent', () => {
  let component: MesReclamationsComponent;
  let fixture: ComponentFixture<MesReclamationsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MesReclamationsComponent]
    });
    fixture = TestBed.createComponent(MesReclamationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
