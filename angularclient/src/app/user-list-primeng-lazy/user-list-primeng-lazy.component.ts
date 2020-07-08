import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { UserService } from '../service/user.service';
import {TableModule} from 'primeng/table';
import {LazyLoadEvent, SortEvent} from 'primeng/api';

@Component({
  selector: 'app-user-list-primeng-lazy',
  templateUrl: './user-list-primeng-lazy.component.html',
  styleUrls: ['./user-list-primeng-lazy.component.css']
})
export class UserListPrimengLazyComponent implements OnInit {

  users: User[];
  totalRecords: number;
  cols: any[];
  loading: boolean;

  constructor(private userService: UserService) {
  }

  ngOnInit() {
    this.cols = [
                { field: 'id', header: 'Id' },
                { field: 'login', header: 'Login' },
                { field: 'eloranking', header: 'EloRanking' }
            ];
  }

  loadDataLazy(event: LazyLoadEvent) {
    this.loading = true;
    this.userService.findAllPaginated(
              event.first / event.rows, event.rows,
              event.sortField, event.sortOrder).subscribe(data => {
      this.users = data.users;
      this.totalRecords = data.totalRecords;
      this.loading = false;
    });
  }

}
