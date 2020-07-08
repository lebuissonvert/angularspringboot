package app.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity(name = "Eleve")
@Table(name = "eleves")
public class Eleve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ideleve;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prenom", nullable = false)
    private String prenom;

    @Column(name = "mail", nullable = false)
    private String mail;

    @Column(name = "tel", nullable = false)
    private String tel;

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "idtypeeleve", // eleves.idtypeeleve
            referencedColumnName="idtypeeleve", // reftypeeleve.idtypeeleve
            foreignKey=@ForeignKey(name = "Fk_eleve_typeeleve"), // FK créée dans eleve
            nullable=false,
            columnDefinition = "integer default 1")
    private TypeEleve typeEleve;

    public Integer getIdeleve() {
        return ideleve;
    }

    public void setIdeleve(Integer ideleve) {
        this.ideleve = ideleve;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public TypeEleve getTypeEleve() {
        return typeEleve;
    }

    public void setTypeEleve(TypeEleve typeEleve) {
        this.typeEleve = typeEleve;
    }

    @Override
    public String toString() {
        return "Eleve [ideleve=" + ideleve + ", nom=" + nom +
                ", prenom=" + prenom + ", mail=" + mail +
                ", tel=" + tel + ", typeeleve=" + typeEleve.getCodetypeeleve() + "]";
    }
}
