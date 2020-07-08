import {Component, OnInit} from '@angular/core';
import {FormControl} from '@angular/forms';
import {Observable} from 'rxjs';
import {map, startWith} from 'rxjs/operators';
import { UserService } from '../service/user.service';
import { User } from '../model/user';

@Component({
  selector: 'app-mat-user-autocomplete',
  templateUrl: './mat-user-autocomplete.component.html',
  styleUrls: ['./mat-user-autocomplete.component.css']
})
export class MatUserAutocompleteComponent implements OnInit {
  myControl = new FormControl();
  users: User[] = [];
  selectedUser: User = new User();
  filteredOptions: Observable<User[]>;

  constructor(private userService: UserService) {
  }

  ngOnInit() {
    this.userService.findAllOrderByLogin().subscribe(data => {
        this.users = data;
      });

    this.filteredOptions = this.myControl.valueChanges
      .pipe(
        startWith(''),
        map(value => typeof value === 'string' ? value : value.login),
        map(login => login ? this._filter(login) : this.users.slice())
      );
  }

  doSelectionChanged(event) {
    this.selectedUser = event.value;
  }

  displayFn(user: User): string {
    this.selectedUser = user;
    return user && user.login ? user.login : '';
  }

  private _filter(login: string): User[] {
    const filterValue = login.toLowerCase();
    return this.users.filter(user => user.login.toLowerCase().includes(filterValue));
  }
}
