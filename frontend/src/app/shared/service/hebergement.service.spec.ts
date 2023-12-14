import { TestBed } from '@angular/core/testing';

import { HebergementService } from './hebergement.service';

describe('HebergementService', () => {
  let service: HebergementService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HebergementService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
