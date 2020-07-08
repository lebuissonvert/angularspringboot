import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { Icone } from '../model/icone';
import { UserService } from '../service/user.service';
import { IconeService } from '../service/icone.service';
import {TableModule} from 'primeng/table';
import {FilterUtils} from 'primeng/utils';
import {LazyLoadEvent, SortEvent, FilterMetadata} from 'primeng/api';
import { SelectItem} from 'primeng/primeng';

@Component({
  selector: 'app-user-list-filtering-primeng-lazy',
  templateUrl: './user-list-filtering-primeng-lazy.component.html',
  styleUrls: ['./user-list-filtering-primeng-lazy.component.css']
})
export class UserListFilteringPrimengLazyComponent implements OnInit {

  users: User[];
  totalRecords: number;
  cols: any[];
  loading: boolean;

  elorankingFilter: number;
  elorankingTimeout: any;

  iconFilter: SelectItem[];

  constructor(private userService: UserService, private iconeService: IconeService) {
  }

  ngOnInit() {
      this.cols = [
                  { field: 'id', header: 'Id' },
                  { field: 'login', header: 'Login' },
                  { field: 'eloranking', header: 'EloRanking' },
                  { field: 'icone.codeIcone', header: 'Icone' }
              ];

      this.getIconeFilter();

      FilterUtils['custom'] = (value, filter): boolean => {
          if (filter === undefined || filter === null || filter.trim() === '') {
              return true;
          }
          if (value === undefined || value === null) {
              return false;
          }
          return parseInt(filter) > value;
      }
  }

  getIconeFilter() {
      this.loading = true;
      this.iconeService.findAll().subscribe(data => {
        this.iconFilter = [];
        data.forEach(el => {
          this.iconFilter.push({label: el.codeIcone, value: el.idicone});
        });
        this.loading = false;
      });
    }

  onElorankingChange(event, dt) {
     if (this.elorankingTimeout) {
         clearTimeout(this.elorankingTimeout);
     }

     this.elorankingTimeout = setTimeout(() => {
         dt.filter(event.value, 'eloranking', 'gt');
     }, 250);
  }

  loadDataLazy(event: LazyLoadEvent) {
    this.loading = true;
    this.userService.findAllPaginatedFiltered(
              event.first / event.rows, event.rows,
              event.sortField, event.sortOrder, event.filters).subscribe(data => {
      this.users = data.users;
      this.totalRecords = data.totalRecords;
      this.loading = false;
    });
  }

}
