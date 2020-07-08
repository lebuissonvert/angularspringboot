package app.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Icone")
@Table(name = "reficone")
public class Icone implements Serializable {

    @Id
    @Column(name = "idicone", columnDefinition = "integer default 1")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idicone;

    @Column(name = "codeicone", nullable = false)
    private String codeIcone;

    public Icone() {
        idicone = 1;
        codeIcone = "NONE";
    }

    public Integer getIdicone() {
        return idicone;
    }

    public void setIdicone(Integer idicone) {
        this.idicone = idicone;
    }

    public String getCodeIcone() {
        return codeIcone;
    }

    public void setCodeIcone(String codeIcone) {
        this.codeIcone = codeIcone;
    }
}
