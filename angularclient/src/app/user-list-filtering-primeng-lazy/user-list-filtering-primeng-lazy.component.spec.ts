import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserListFilteringPrimengLazyComponent } from './user-list-filtering-primeng-lazy.component';

describe('UserListFilteringPrimengLazyComponent', () => {
  let component: UserListFilteringPrimengLazyComponent;
  let fixture: ComponentFixture<UserListFilteringPrimengLazyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserListFilteringPrimengLazyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserListFilteringPrimengLazyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
