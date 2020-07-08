package app.service;

import app.DTO.IconeDTO;

import java.util.List;

public interface IIconeService {

    public List<IconeDTO> findAllByOrderByIdiconeAsc();

}
