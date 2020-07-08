package app.service;

import app.DTO.EleveDTO;
import app.DTO.TypeEleveDTO;
import app.entity.Eleve;
import app.entity.TypeEleve;
import app.repository.EleveRepository;
import app.repository.TypeEleveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EleveServiceImpl implements IEleveService {

    @Autowired
    private EleveRepository eleveRepository;
    @Autowired
    private TypeEleveRepository typeEleveRepository;

    @Override
    public List<TypeEleveDTO> findAllByOrderByIdtypeeleveAsc() {
        List<TypeEleve> typesEleve = eleveRepository.findAllTypeEleveByOrderByIdAsc();
        return typesEleve.stream().map(TypeEleveDTO::new).collect(Collectors.toList());
    }

    @Override
    public Long countEleveWithSameInformationNoCase(String nom, String prenom, String mail, String tel) {
        return eleveRepository.countEleveWithSameInformationNoCase(nom, prenom, mail, tel);
    }

    @Override
    public List<EleveDTO> findEleveWithSameInformationNoCase(String nom, String prenom, String mail, String tel) {
        List<Eleve> eleves = eleveRepository.findEleveWithSameInformationNoCase(nom, prenom, mail, tel);
        return eleves.stream().map(EleveDTO::new).collect(Collectors.toList());
    }

    @Override
    public EleveDTO saveEleve(EleveDTO eleveDTO) {
        Eleve eleve = eleveDTO.toEleve();
        Optional<TypeEleve> typeEleve = typeEleveRepository.findById(eleve.getTypeEleve().getIdtypeeleve());
        eleve.setTypeEleve(typeEleve.get());
        return new EleveDTO(eleveRepository.save(eleve));
    }
}
