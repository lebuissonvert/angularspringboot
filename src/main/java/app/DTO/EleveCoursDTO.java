package app.DTO;

import java.io.Serializable;

public class EleveCoursDTO implements Serializable {
    private EleveDTO eleve;
    private String idcours;

    public EleveCoursDTO(){}

    public EleveDTO getEleve() {
        return eleve;
    }

    public void setEleve(EleveDTO eleve) {
        this.eleve = eleve;
    }

    public String getIdcours() {
        return idcours;
    }

    public void setIdcours(String idcours) {
        this.idcours = idcours;
    }
}
