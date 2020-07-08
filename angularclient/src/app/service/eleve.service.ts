import { Injectable } from '@angular/core';
import { TypeEleve } from '../model/type-eleve';
import { HttpClient, HttpHeaders, HttpParams, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EleveService {

  private baseUrl: string;
  private wsGetTypesEleve: string;

  constructor(private http: HttpClient) {
    this.baseUrl = 'http://localhost:8080/';
    this.wsGetTypesEleve = 'getTypesEleve';
  }

  public findTypesEleves(): Observable<TypeEleve[]> {
    return this.http.get<TypeEleve[]>(this.baseUrl + this.wsGetTypesEleve);
  }
}
