package app.repository;

import app.entity.Eleve;
import app.entity.TypeEleve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EleveRepository extends JpaRepository<Eleve, Integer> {

    List<Eleve> findAll();
    Optional<Eleve> findById(Integer id);

    @Query("select te from TypeEleve te order by te.idtypeeleve asc")
    List<TypeEleve> findAllTypeEleveByOrderByIdAsc();

    @Query("select count(e) from Eleve e WHERE lower(e.nom)=lower(:nom) and lower(e.prenom)=lower(:prenom)" +
            " and lower(e.mail)=lower(:mail) and lower(e.tel)=lower(:tel)")
    Long countEleveWithSameInformationNoCase(
            @Param("nom") String nom, @Param("prenom") String prenom,
            @Param("mail") String mail, @Param("tel") String tel);

    @Query("select e from Eleve e WHERE lower(e.nom)=lower(:nom) and lower(e.prenom)=lower(:prenom)" +
            " and lower(e.mail)=lower(:mail) and lower(e.tel)=lower(:tel)")
    List<Eleve> findEleveWithSameInformationNoCase(
            @Param("nom") String nom, @Param("prenom") String prenom,
            @Param("mail") String mail, @Param("tel") String tel);

}
