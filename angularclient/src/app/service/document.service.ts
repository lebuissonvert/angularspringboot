import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams, HttpErrorResponse } from '@angular/common/http';
import { Document } from '../model/document';
import {Observable} from 'rxjs';
import { catchError} from 'rxjs/operators';

@Injectable()
export class DocumentService {

  private baseUrl: string;
  private wsShowAllDocumentUrl: string;
  private wsShowOneDocumentUrl: string;
  private wsDownloadDocumentUrl: string;
  private wsSaveDocumentUrl: string;
  private wsCreateDocumentUrl: string;

  constructor(private http: HttpClient) {
    this.baseUrl = 'http://localhost:8080/';
    this.wsShowAllDocumentUrl = 'showAllDocument';
    this.wsShowOneDocumentUrl = 'showOneDocument';
    this.wsDownloadDocumentUrl = 'downloadDocument';
    this.wsSaveDocumentUrl = 'saveDocumentFull';
    this.wsCreateDocumentUrl = 'createDocumentFull';
  }

  public findAll(): Observable<Document[]> {
    return this.http.get<Document[]>(this.baseUrl + this.wsShowAllDocumentUrl);
  }

  public findById(id: string): Observable<Document> {
    const obj = {'id': id};
    return this.http.get<Document>(this.baseUrl + this.wsShowOneDocumentUrl, { params: obj});
  }

  public saveDocument(document: Document) {
    const formData: FormData = new FormData();
    formData.append('file', document.document, "document_" + document.idDocument + ".pdf");
    formData.append('idDocument', document.idDocument+"");
    formData.append('codeDocument', document.codeDocument);
    return this.http.post<any>( this.baseUrl + this.wsSaveDocumentUrl, formData);
  }

  public createDocument(document: Document) {
    const formData: FormData = new FormData();
    formData.append('file', document.document, "document_" + document.idDocument + ".pdf");
    formData.append('codeDocument', document.codeDocument);
    return this.http.post<any>( this.baseUrl + this.wsCreateDocumentUrl, formData);
  }

  public async downloadDocument(p_id: string): Promise<void> {
    // Récupération du blob en BDD via webservice
    const obj = {'id': p_id};
    const blob = await this.http.get<Blob>(
                   	  this.baseUrl + this.wsDownloadDocumentUrl,
                   		{params: obj, responseType: 'blob' as 'json'}).toPromise();
    const url = window.URL.createObjectURL(blob);

    // Lancement du telechargement du blob dans le navigateur
    let a = document.createElement('a');
    document.body.appendChild(a);
    a.setAttribute('style', 'display: none');
    a.href = url;
    a.download = 'document_'+p_id+'.pdf';
    a.click();
    window.URL.revokeObjectURL(url);
    a.remove();
    window.URL.revokeObjectURL(url);
  }
}
