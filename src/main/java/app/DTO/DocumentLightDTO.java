package app.DTO;

import app.entity.Document;
import app.entity.Icone;

import java.io.Serializable;

public class DocumentLightDTO implements Serializable {
    private Integer idDocument;
    private String codeDocument;

    private DocumentLightDTO(){}

    public DocumentLightDTO(Document document) {
        this.idDocument = document.getIdDocument();
        this.codeDocument = document.getCodeDocument();
    }

    public Document toDocument() {
        Document resultat = new Document();
        resultat.setCodeDocument(codeDocument);
        resultat.setIdDocument(idDocument);
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
}
