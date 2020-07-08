import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserListMaterialComponent } from './user-list-material.component';

describe('UserListMaterialComponent', () => {
  let component: UserListMaterialComponent;
  let fixture: ComponentFixture<UserListMaterialComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserListMaterialComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserListMaterialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
