package app.repository;

import app.DTO.UserFilterDTO;
import app.entity.RewardsStats;
import app.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Repository
public interface UserRepositoryCustom {
    public List<User> findAllFiltered(Pageable pageable, HashMap<String, UserFilterDTO> filters);
    public long count(HashMap<String, UserFilterDTO> filters);
    public int updateUser(Integer id, String login, Date horodatage);

    public boolean deleteByLoginStartsWith(String loginLike);

    public List<RewardsStats> getRewardsStats();
}
