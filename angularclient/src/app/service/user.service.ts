import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams, HttpErrorResponse } from '@angular/common/http';
import { User } from '../model/user';
import { Chart } from '../model/chart';
import { PaginatedUser } from '../model/paginated-user';
import {Observable} from 'rxjs';
import { catchError} from 'rxjs/operators';
import {FilterMetadata} from 'primeng/api';

@Injectable()
export class UserService {

  private baseUrl: string;
  private wsShowAllUserUrl: string;
  private wsShowAllUserOrderByLoginUrl: string;
  private wsShowAllUserPaginatedUrl: string;
  private wsShowOneUserUrl: string;
  private wsCreateUserUrl: string;
  private wsSaveUserUrl: string;
  private wsGetRewardsStats: string;

  constructor(private http: HttpClient) {
    this.baseUrl = 'http://localhost:8080/';
    this.wsShowAllUserUrl = 'showAllUser';
    this.wsShowAllUserOrderByLoginUrl = 'showAllUserOrderByLogin';
    this.wsShowAllUserPaginatedUrl = 'showAllUserPaginated';
    this.wsShowOneUserUrl = 'showOneUser';
    this.wsCreateUserUrl = 'createUser';
    this.wsSaveUserUrl = 'saveUser';
    this.wsGetRewardsStats = 'getRewardsStats';
  }

  public findAll(): Observable<User[]> {
    return this.http.get<User[]>(this.baseUrl + this.wsShowAllUserUrl);
  }

  public findAllOrderByLogin(): Observable<User[]> {
    return this.http.get<User[]>(this.baseUrl + this.wsShowAllUserOrderByLoginUrl);
  }

  public findAllPaginated(
             page: number, size: number,
             sortField: string, sortOrder: number): Observable<PaginatedUser> {
     const obj = {'page': page+'', 'size': size+'', 'sortfield': sortField, 'sortorder': sortOrder+''};
     return this.http.get<PaginatedUser>(this.baseUrl + this.wsShowAllUserPaginatedUrl, { params: obj});
  }

  public getCharts() {
    return this.http.get<Chart[]>(this.baseUrl + this.wsGetRewardsStats);
  }

  public findAllPaginatedFiltered(
            page: number, size: number,
            sortField: string, sortOrder: number, p_filters: FilterMetadata): Observable<PaginatedUser> {
    const obj = {
          'page': page+'',
          'size': size+'',
          'sortfield': sortField,
          'sortorder': sortOrder+'',
          'filters': JSON.stringify(p_filters)};
    return this.http.get<PaginatedUser>(this.baseUrl + this.wsShowAllUserPaginatedUrl, { params: obj});
    /*
       page: 0
       size: 5
       sortfield: undefined
       sortorder: 1
       filters: {"login":{"value":"aa","matchMode":"contains"},"eloranking":{"value":1563,"matchMode":"gt"}}
       */
  }

  public findById(id: string): Observable<User> {
    const obj = {'id': id};
    return this.http.get<User>(this.baseUrl + this.wsShowOneUserUrl, { params: obj});
  }

  public createUser(login: string) {
    return this.http.post<User>(this.baseUrl + this.wsCreateUserUrl, login);
  }

  public saveUser(user: User) {
    return this.http.post<User>(this.baseUrl + this.wsSaveUserUrl, user);
  }
}
