package app.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Document")
@Table(name = "refdocuments")
public class Document implements Serializable {

    @Id
    @Column(name = "iddocument", columnDefinition = "integer default 1")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddocument;

    @Column(name = "codedocument", nullable = false)
    private String codedocument;

    @Column(name = "document", nullable = false)
    private byte[] document;

    public Document() {
        iddocument = 1;
        codedocument = "NONE";
    }

    public Integer getIdDocument() {
        return iddocument;
    }

    public void setIdDocument(Integer iddocument) {
        this.iddocument = iddocument;
    }

    public String getCodeDocument() {
        return codedocument;
    }

    public void setCodeDocument(String codedocument) {
        this.codedocument = codedocument;
    }

    public byte[] getDocument() {
        return document;
    }

    public void setDocument(byte[] document) {
        this.document = document;
    }
}
