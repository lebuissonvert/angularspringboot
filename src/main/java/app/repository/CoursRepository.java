package app.repository;

import app.entity.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CoursRepository extends JpaRepository<Cours, Integer> {

    List<Cours> findAll();

    @Query("select c from Cours c where year(c.start) = :year and month(c.start) = :month")
    List<Cours> getByYearAndMonth(@Param("year") Integer year, @Param("month") Integer month);

    Optional<Cours> findById(Integer id);

}
