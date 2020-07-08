import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams, HttpErrorResponse } from '@angular/common/http';
import { Cours } from '../model/cours';
import { Eleve } from '../model/eleve';
import { Elevecours } from '../model/elevecours';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CoursService {

  private baseUrl: string;
  private wsGetCoursByMonthAndYear: string;
  private wsAjouterEleveDansCoursUrl: string;

  constructor(private http: HttpClient) {
    this.baseUrl = 'http://localhost:8080/';
    this.wsGetCoursByMonthAndYear = 'getCoursByMonthAndYear';
    this.wsAjouterEleveDansCoursUrl = 'ajouterEleveDansCours';
  }

  public findByMonthAndYear(month: number, year: number): Observable<Cours[]> {
    const obj = {'month': month+'', 'year': year+''};
    return this.http.get<Cours[]>(this.baseUrl + this.wsGetCoursByMonthAndYear, { params: obj});
  }

  public ajouterEleveDansCours(eleve: Eleve, idCours: number) {
    let elevecours: Elevecours = new Elevecours(eleve, idCours);
    return this.http.post<Elevecours>(this.baseUrl + this.wsAjouterEleveDansCoursUrl, elevecours);
  }
}
