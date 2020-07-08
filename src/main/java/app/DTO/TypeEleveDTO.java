package app.DTO;

import app.entity.TypeEleve;

import java.io.Serializable;

public class TypeEleveDTO implements Serializable {
    private Integer idtypeeleve;
    private String codetypeeleve;

    private TypeEleveDTO(){}

    public TypeEleveDTO(TypeEleve p_typeeleve) {
        this.idtypeeleve = p_typeeleve.getIdtypeeleve();
        this.codetypeeleve = p_typeeleve.getCodetypeeleve();
    }

    public TypeEleve toTypeEleve() {
        TypeEleve resultat = new TypeEleve();
        resultat.setCodetypeeleve(codetypeeleve);
        resultat.setIdtypeeleve(idtypeeleve);
        return resultat;
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
