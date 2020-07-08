import { Component, OnInit } from '@angular/core';
import { Document } from '../model/document';
import { DocumentService } from '../service/document.service';

@Component({
  selector: 'app-document-list',
  templateUrl: './document-list.component.html',
  styleUrls: ['./document-list.component.css']
})
export class DocumentListComponent implements OnInit {

  documents: Document[];
  downloadIconeURL: any = "assets/images/download.png";

  constructor(private documentService: DocumentService) {
  }

  ngOnInit() {
    this.documentService.findAll().subscribe(data => {
      this.documents = data;
    });
  }

  download(idDocument: number) {
    this.documentService.downloadDocument(idDocument+"");
  }
}
