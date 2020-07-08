package app.DTO;

import app.entity.Cours;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CoursDTO implements Serializable {
    private Integer id;
    private String title;
    private Date start;
    private Date end;
    private String adresse;
    private String niveau;
    private String prof;
    private String ville;
    private Integer nbCavaliers;
    private Integer nbCavalieres;
    Set<EleveDTO> eleves = new HashSet<>();

    public CoursDTO(){}

    public CoursDTO(Cours cours) {
        this.id = cours.getIdcours();
        this.title = cours.getTitle();
        this.start = cours.getStart();
        this.end = cours.getEnd();
        this.niveau = cours.getNiveau();
        this.prof = cours.getProf();
        this.ville = cours.getVille();
        this.adresse = cours.getAdresse();
        this.nbCavalieres = cours.getNbCavalieres();
        this.nbCavaliers = cours.getNbCavaliers();
        this.eleves = cours.getEleves().stream().map(EleveDTO::new).collect(Collectors.toSet());
    }

    public Cours toCours() {
        Cours resultat = new Cours();
        resultat.setAdresse(adresse);
        resultat.setEleves(eleves.stream().map(EleveDTO::toEleve).collect(Collectors.toSet()));
        resultat.setEnd(end);
        resultat.setIdcours(id);
        resultat.setNbCavalieres(nbCavalieres);
        resultat.setNbCavaliers(nbCavaliers);
        resultat.setNiveau(niveau);
        resultat.setProf(prof);
        resultat.setStart(start);
        resultat.setTitle(title);
        resultat.setVille(ville);
        return resultat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Set<EleveDTO> getEleves() {
        return eleves;
    }

    public void setEleves(Set<EleveDTO> eleves) {
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
