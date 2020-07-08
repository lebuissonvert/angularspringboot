import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams, HttpErrorResponse } from '@angular/common/http';
import { Icone } from '../model/icone';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class IconeService {

  private baseUrl: string;
  private wsShowAllIconeUrl: string;

  constructor( private http: HttpClient) {
    this.baseUrl = 'http://localhost:8080/';
    this.wsShowAllIconeUrl = 'showAllIcone';
  }

  public findAll(): Observable<Icone[]> {
    return this.http.get<Icone[]>(this.baseUrl + this.wsShowAllIconeUrl);
  }
}
