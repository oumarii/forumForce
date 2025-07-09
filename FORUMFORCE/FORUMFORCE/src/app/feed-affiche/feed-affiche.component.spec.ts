import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FeedAfficheComponent } from './feed-affiche.component';

describe('FeedAfficheComponent', () => {
  let component: FeedAfficheComponent;
  let fixture: ComponentFixture<FeedAfficheComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FeedAfficheComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FeedAfficheComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
