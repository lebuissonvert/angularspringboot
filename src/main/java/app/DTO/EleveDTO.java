package app.DTO;

import app.entity.Eleve;

import java.io.Serializable;

public class EleveDTO implements Serializable {

    private Integer id;
    private TypeEleveDTO typeEleve;
    private String nom;
    private String prenom;
    private String mail;
    private String tel;

    public EleveDTO() {}

    public EleveDTO(Eleve eleve) {
        this.id = eleve.getIdeleve();
        this.typeEleve = new TypeEleveDTO(eleve.getTypeEleve());
        this.nom = eleve.getNom();
        this.prenom = eleve.getPrenom();
        this.mail = eleve.getMail();
        this.tel = eleve.getTel();
    }

    public Eleve toEleve() {
        Eleve resultat = new Eleve();
        resultat.setIdeleve(this.id);
        resultat.setMail(this.mail);
        resultat.setNom(this.nom);
        resultat.setPrenom(this.prenom);
        resultat.setTel(this.tel);
        resultat.setTypeEleve(this.typeEleve.toTypeEleve());
        return resultat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TypeEleveDTO getTypeEleve() {
        return typeEleve;
    }

    public void setTypeEleve(TypeEleveDTO typeEleve) {
        this.typeEleve = typeEleve;
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
}
