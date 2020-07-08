package app.service;

import app.DTO.CoursDTO;

import java.util.List;

public interface ICoursService {

    CoursDTO findById(Integer id);
    List<CoursDTO> getByYearAndMonth(Integer year, Integer month);

    public CoursDTO saveCours(CoursDTO coursDTO);
    public CoursDTO linkEleveAndCours(Integer idEleve, Integer idCours);
}
