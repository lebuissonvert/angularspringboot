package app.repository;

import app.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer>, UserRepositoryCustom { // Integer: Type of User ID.

    User findByLogin(String login);

    List<User> findByLoginStartsWith(String login);
    List<User> findAllByOrderByIdAsc();
    List<User> findAllByOrderByLoginAsc();
    Page<User> findAll(Pageable pageable);

    long count();

    List<User> findByHorodatageGreaterThan(Date hireDate);

    @Query("SELECT coalesce(max(u.id), 0) FROM User u")
    Integer getMaxId();

}
