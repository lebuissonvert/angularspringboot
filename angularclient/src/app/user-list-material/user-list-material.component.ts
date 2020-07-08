import { Component, OnInit, ViewChild } from '@angular/core';
import { User } from '../model/user';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-user-list-material',
  templateUrl: './user-list-material.component.html',
  styleUrls: ['./user-list-material.component.css']
})
export class UserListMaterialComponent implements OnInit {

  displayedColumns: string[] = ['id', 'login', 'eloranking'];
  dataSource = new MatTableDataSource<User>();

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort: MatSort;

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;

    this.userService.findAll().subscribe(data => {
      this.dataSource.data = data;
    });
  }

}
