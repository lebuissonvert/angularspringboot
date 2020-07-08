import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserListPrimengComponent } from './user-list-primeng.component';

describe('UserListPrimengComponent', () => {
  let component: UserListPrimengComponent;
  let fixture: ComponentFixture<UserListPrimengComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserListPrimengComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserListPrimengComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
