package app.service;

import app.DTO.PaginatedUserDTO;
import app.DTO.RewardsStatsDTO;
import app.DTO.UserDTO;
import app.DTO.UserFilterDTO;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface IUserService {

    public boolean deleteByLoginStartsWith(String loginLike);

    public UserDTO findByLogin(String login);
    public UserDTO findById(Integer id);

    public List<UserDTO> findByLoginStartsWith(String login);
    public List<UserDTO> findAll();
    public List<UserDTO> findAllByOrderByIdAsc();
    public List<UserDTO> findAllByOrderByLoginAsc();
    public PaginatedUserDTO findAllPaginated(int p_page, int p_pageSize, String sortField, String sortOrder);
    public PaginatedUserDTO findAllPaginated(
            int p_page, int p_pageSize,
            String sortField, String sortOrder,
            HashMap<String, UserFilterDTO> filterMap);
    public List<RewardsStatsDTO> getRewardsStats();
    public List<UserDTO> findByHorodatageGreaterThan(Date horodatage);

    public UserDTO saveUser(UserDTO user);
    public UserDTO createUser(String p_login);

    public Integer getMaxId();
}
