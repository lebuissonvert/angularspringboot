package app.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Cours")
@Table(name = "cours")
public class Cours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcours;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "start", nullable = false)
    private Date start;

    @Column(name = "end", nullable = false)
    private Date end;

    @Column(name = "adresse", nullable = false)
    private String adresse;

    @Column(name = "niveau", nullable = false)
    private String niveau;

    @Column(name = "prof", nullable = false)
    private String prof;

    @Column(name = "ville", nullable = false)
    private String ville;

    @Column(name = "nbCavaliers", nullable = false)
    private Integer nbCavaliers;

    @Column(name = "nbCavalieres", nullable = false)
    private Integer nbCavalieres;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "courseleve",
            joinColumns = { @JoinColumn(name = "idcours") },
            inverseJoinColumns = { @JoinColumn(name = "ideleve") }
    )
    Set<Eleve> eleves = new HashSet<>();

    public Integer getIdcours() {
        return idcours;
    }

    public void setIdcours(Integer idcours) {
        this.idcours = idcours;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Integer getNbCavaliers() {
        return nbCavaliers;
    }

    public void setNbCavaliers(Integer nbCavaliers) {
        this.nbCavaliers = nbCavaliers;
    }

    public Integer getNbCavalieres() {
        return nbCavalieres;
    }

    public void setNbCavalieres(Integer nbCavalieres) {
        this.nbCavalieres = nbCavalieres;
    }

    public Set<Eleve> getEleves() {
        return eleves;
    }

    public void setEleves(Set<Eleve> eleves) {
        this.eleves = eleves;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
