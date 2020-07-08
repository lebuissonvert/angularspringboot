import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { UserService } from '../service/user.service';
import {TableModule} from 'primeng/table';
import {LazyLoadEvent} from 'primeng/api';

@Component({
  selector: 'app-user-list-primeng',
  templateUrl: './user-list-primeng.component.html',
  styleUrls: ['./user-list-primeng.component.css']
})
export class UserListPrimengComponent implements OnInit {

  users: User[];
  totalRecords: number;
  cols: any[];

  constructor(private userService: UserService) {
  }

  ngOnInit() {
    this.userService.findAll().subscribe(data => {
      this.users = data;
    });
    /*this.userService.findAllPaginated(0,5).subscribe(data => {
      this.users = data.users;
      this.totalRecords = data.totalRecords;
    });*/
    this.cols = [
                { field: 'id', header: 'Id' },
                { field: 'login', header: 'Login' },
                { field: 'eloranking', header: 'EloRanking' }
            ];
  }

  loadData(event: LazyLoadEvent) {
      //event.first = First row offset
      //event.rows = Number of rows per page
      //event.sortField = Field name to sort in single sort mode
      //event.sortOrder = Sort order as number, 1 for asc and -1 for dec in single sort mode
      //multiSortMeta: An array of SortMeta objects used in multiple columns sorting. Each SortMeta has field and order properties.
      //filters: Filters object having field as key and filter value, filter matchMode as value
      //globalFilter: Value of the global filter if available
      //this.users = do a request to a remote datasource using a service and return the cars that match the lazy load criteria

      this.userService.findAll().subscribe(data => {
        this.users = data;
      });
      /*this.userService.findAllPaginated(event.first,event.rows).subscribe(data => {
        this.users = data.users;
        this.totalRecords = data.totalRecords;
      });*/
  }

}
