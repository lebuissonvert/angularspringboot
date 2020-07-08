import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../service/user.service';
import { User } from '../model/user';
import { filter, pairwise } from 'rxjs/operators';
import { RoutesRecognized} from '@angular/router';
import {Location} from '@angular/common';

@Component({
  selector: 'app-user-edit-form',
  templateUrl: './user-edit-form.component.html',
  styleUrls: ['./user-edit-form.component.css']
})
export class UserEditFormComponent implements OnInit {

  user: User;
  id: string;
  previousURL: string;

  constructor(private route: ActivatedRoute, private router: Router, private userService: UserService,
              private _location: Location) {
    this.user = new User();
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.userService.findById(this.id).subscribe(
      result => {
        this.user = result;
        });
  }

  onSubmit() {
    this.userService.saveUser(this.user).subscribe(result => this.gotoUserList());
  }

  gotoUserList() {
    //this.router.navigate(['users']);
    this._location.back();
  }

}
