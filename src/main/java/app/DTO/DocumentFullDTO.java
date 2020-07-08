package app.DTO;

import app.entity.Document;

import java.io.Serializable;

public class DocumentFullDTO implements Serializable {
    private Integer idDocument;
    private String codeDocument;
    private byte[] document;

    private DocumentFullDTO(){}

    public DocumentFullDTO(Document document) {
        this.idDocument = document.getIdDocument();
        this.codeDocument = document.getCodeDocument();
        this.document = document.getDocument();
    }

    public Document toDocument() {
        Document resultat = new Document();
        resultat.setCodeDocument(codeDocument);
        resultat.setIdDocument(idDocument);
        resultat.setDocument(document);
        return resultat;
    }

    public Integer getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(Integer idDocument) {
        this.idDocument = idDocument;
    }

    public String getCodeDocument() {
        return codeDocument;
    }

    public void setCodeDocument(String codeDocument) {
        this.codeDocument = codeDocument;
    }

    public byte[] getDocument() {
        return document;
    }

    public void setDocument(byte[] document) {
        this.document = document;
    }
}
