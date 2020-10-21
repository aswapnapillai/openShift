import { TestBed } from '@angular/core/testing';

import { BookRecommendationService } from './bookRecommendation.service';

describe('BookRecommendationService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BookRecommendationService = TestBed.get(BookRecommendationService);
    expect(service).toBeTruthy();
  });
});
