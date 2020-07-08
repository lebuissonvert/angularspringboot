package app.service;

import app.DTO.CoursDTO;
import app.entity.Cours;
import app.entity.Eleve;
import app.repository.CoursRepository;
import app.repository.EleveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CoursServiceImpl implements ICoursService {

    @Autowired
    private CoursRepository coursRepository;
    @Autowired
    private EleveRepository eleveRepository;

    @Override
    public CoursDTO findById(Integer id) {
        CoursDTO resultat = null;
        Optional<Cours> optCours = coursRepository.findById(id);
        if(optCours.isPresent()) {
            resultat = new CoursDTO(optCours.get());
        }
        return resultat;
    }

    @Override
    public List<CoursDTO> getByYearAndMonth(Integer year, Integer month) {
        List<CoursDTO> resultat = new ArrayList<>();
        if(year != null && month != null) {
            List<Cours> cours = coursRepository.getByYearAndMonth(year, month);
            resultat = cours.stream().map(CoursDTO::new).collect(Collectors.toList());
        }
        return resultat;
    }

    @Override
    public CoursDTO saveCours(CoursDTO coursDTO) {
        CoursDTO resultat = null;
        Cours cours = coursRepository.save(coursDTO.toCours());
        if(cours != null) {
            resultat = new CoursDTO(cours);
        }
        return resultat;
    }

    @Override
    public CoursDTO linkEleveAndCours(Integer idEleve, Integer idCours) {
        CoursDTO resultat = null;
        Optional<Cours> optCours = coursRepository.findById(idCours);
        Optional<Eleve> optEleve = eleveRepository.findById(idEleve);
        if(optCours.isPresent() && optEleve.isPresent()) {
            Cours cours = optCours.get();
            Eleve eleve = optEleve.get();
            boolean eleveAlreadyInCours = false;
            for(Eleve curEleve : cours.getEleves()) {
                if(curEleve.getIdeleve().equals(eleve.getIdeleve())) {
                    eleveAlreadyInCours = true;
                    break;
                }
            }
            if(!eleveAlreadyInCours) {
                cours.getEleves().add(eleve);
                resultat = new CoursDTO(coursRepository.save(cours));
            } else {
                resultat = new CoursDTO(cours);
            }
        }
        return resultat;
    }
}
