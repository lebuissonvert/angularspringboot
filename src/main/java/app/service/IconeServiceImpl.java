package app.service;

import app.DTO.IconeDTO;
import app.entity.Icone;
import app.repository.IconeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IconeServiceImpl implements IIconeService {

    @Autowired
    private IconeRepository iconeRepository;

    @Override
    public List<IconeDTO> findAllByOrderByIdiconeAsc() {
        List<IconeDTO> result = new ArrayList<>();
        List<Icone> icones = iconeRepository.findAllByOrderByIdiconeAsc();
        result = icones.stream().map(IconeDTO::new).collect(Collectors.toList());
        return result;
    }
}
