package app.DTO;

import app.entity.Icone;

import java.io.Serializable;

public class IconeDTO implements Serializable {
    private Integer idicone;
    private String codeIcone;

    private IconeDTO(){}

    public IconeDTO(Icone icone) {
        this.idicone = icone.getIdicone();
        this.codeIcone = icone.getCodeIcone();
    }

    public Icone toIcone() {
        Icone resultat = new Icone();
        resultat.setCodeIcone(codeIcone);
        resultat.setIdicone(idicone);
        return resultat;
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
