package app.service;

import app.DTO.EleveDTO;
import app.DTO.TypeEleveDTO;

import java.util.List;

public interface IEleveService {

    public List<TypeEleveDTO> findAllByOrderByIdtypeeleveAsc();
    public Long countEleveWithSameInformationNoCase(String nom, String prenom, String mail, String tel);
    public List<EleveDTO> findEleveWithSameInformationNoCase(String nom, String prenom, String mail, String tel);
    public EleveDTO saveEleve(EleveDTO eleveDTO);

}
