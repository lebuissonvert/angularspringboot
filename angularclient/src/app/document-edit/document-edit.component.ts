import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DocumentService } from '../service/document.service';
import { Document } from '../model/document';

@Component({
  selector: 'app-document-edit',
  templateUrl: './document-edit.component.html',
  styleUrls: ['./document-edit.component.css']
})
export class DocumentEditComponent implements OnInit {

  document: Document;
  fileToUpload: File = null;

  constructor(private route: ActivatedRoute, private router: Router, private documentService: DocumentService) {
    this.document = new Document();
  }

  ngOnInit(): void {
    const id = this.route.snapshot.params['id'];
    this.documentService.findById(id).subscribe(
      result => {
        this.document = result;
        }
    );
  }

  handleFileInput(files: FileList) {
      this.fileToUpload = files.item(0);
      this.document.document = this.fileToUpload;
  }

  onSubmit() {
    this.documentService.saveDocument(this.document).subscribe(result => this.gotoDocumentList());
  }

  gotoDocumentList() {
    this.router.navigate(['documents']);
  }
}
