import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserListPrimengLazyComponent } from './user-list-primeng-lazy.component';

describe('UserListPrimengLazyComponent', () => {
  let component: UserListPrimengLazyComponent;
  let fixture: ComponentFixture<UserListPrimengLazyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserListPrimengLazyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserListPrimengLazyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
