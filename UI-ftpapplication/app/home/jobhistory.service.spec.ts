import { TestBed } from '@angular/core/testing';

import { JobhistoryService } from './jobhistory.service';

describe('JobhistoryService', () => {
  let service: JobhistoryService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(JobhistoryService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
