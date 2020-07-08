import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MatUserAutocompleteComponent } from './mat-user-autocomplete.component';

describe('MatUserAutocompleteComponent', () => {
  let component: MatUserAutocompleteComponent;
  let fixture: ComponentFixture<MatUserAutocompleteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MatUserAutocompleteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MatUserAutocompleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
