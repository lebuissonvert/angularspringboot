import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DocumentService } from '../service/document.service';
import { Document } from '../model/document';

@Component({
  selector: 'app-document-add',
  templateUrl: './document-add.component.html',
  styleUrls: ['./document-add.component.css']
})
export class DocumentAddComponent implements OnInit {

  document: Document;
  fileToUpload: File = null;

  constructor(private route: ActivatedRoute, private router: Router, private documentService: DocumentService) {
      this.document = new Document();
  }

  ngOnInit(): void {
  }

  handleFileInput(files: FileList) {
      this.fileToUpload = files.item(0);
      this.document.document = this.fileToUpload;
  }

  onSubmit() {
    this.documentService.createDocument(this.document).subscribe(result => this.gotoDocumentList());
  }

  gotoDocumentList() {
    this.router.navigate(['documents']);
  }

}
