package app.entity;

import javax.persistence.*;

@Entity(name = "TypeEleve")
@Table(name = "reftypeeleve",
        uniqueConstraints={
                @UniqueConstraint(name="codetypeeleve", columnNames={"codetypeeleve"})
        })
public class TypeEleve {

    @Id
    @Column(name = "idtypeeleve")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idtypeeleve;

    @Column(name = "codetypeeleve", nullable = false)
    private String codetypeeleve;

    public TypeEleve() {
        idtypeeleve = 1;
        codetypeeleve = "Guideur";
    }

    public Integer getIdtypeeleve() {
        return idtypeeleve;
    }

    public void setIdtypeeleve(Integer idtypeeleve) {
        this.idtypeeleve = idtypeeleve;
    }

    public String getCodetypeeleve() {
        return codetypeeleve;
    }

    public void setCodetypeeleve(String codetypeeleve) {
        this.codetypeeleve = codetypeeleve;
    }
}
