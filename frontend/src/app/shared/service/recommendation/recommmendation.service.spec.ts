import { TestBed } from '@angular/core/testing';

import { RecommmendationService } from './recommmendation.service';

describe('RecommmendationService', () => {
  let service: RecommmendationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RecommmendationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
