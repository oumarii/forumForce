import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlanninEntrepriseComponent } from './plannin-entreprise.component';

describe('PlanninEntrepriseComponent', () => {
  let component: PlanninEntrepriseComponent;
  let fixture: ComponentFixture<PlanninEntrepriseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PlanninEntrepriseComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PlanninEntrepriseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
