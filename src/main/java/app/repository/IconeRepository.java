package app.repository;

import app.entity.Icone;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IconeRepository extends CrudRepository<Icone, Integer> {

    Icone findByCodeIcone(String codeIcone);
    List<Icone> findAllByOrderByIdiconeAsc();

}
