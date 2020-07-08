package app.service;

import app.DTO.PaginatedUserDTO;
import app.DTO.RewardsStatsDTO;
import app.DTO.UserDTO;
import app.DTO.UserFilterDTO;
import app.entity.RewardsStats;
import app.entity.User;
import app.repository.IconeRepository;
import app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IconeRepository iconeRepository;

    @Override
    public boolean deleteByLoginStartsWith(String loginLike) {
        return userRepository.deleteByLoginStartsWith(loginLike);
    }

    @Override
    public UserDTO findByLogin(String login) {
        return new UserDTO(userRepository.findByLogin(login));
    }

    @Override
    public UserDTO findById(Integer id) {
        UserDTO resultat = null;
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            resultat = new UserDTO(user.get());
        }
        return resultat;
    }

    @Override
    public List<UserDTO> findByLoginStartsWith(String login) {
        List<UserDTO> resultat = new ArrayList<>();
        userRepository.findByLoginStartsWith(login).forEach(curUser -> {
            resultat.add(new UserDTO(curUser));
        });
        return resultat;
    }

    @Override
    public List<UserDTO> findAll() {
        List<UserDTO> result = new ArrayList<>();
        Iterable<User> users = userRepository.findAll();
        for(User curUser : users) {
            result.add(new UserDTO(curUser));
        }
        return result;
    }

    @Override
    public List<UserDTO> findAllByOrderByIdAsc() {
        List<UserDTO> result = new ArrayList<>();
        Iterable<User> users = userRepository.findAllByOrderByIdAsc();
        for(User curUser : users) {
            result.add(new UserDTO(curUser));
        }
        return result;
    }

    @Override
    public List<UserDTO> findAllByOrderByLoginAsc() {
        List<UserDTO> result = new ArrayList<>();
        Iterable<User> users = userRepository.findAllByOrderByLoginAsc();
        for(User curUser : users) {
            result.add(new UserDTO(curUser));
        }
        return result;
    }

    @Override
    public PaginatedUserDTO findAllPaginated(
            int p_page, int p_pageSize, String sortField, String sortOrder) {
        Sort sort = new Sort(Sort.Direction.fromString(sortOrder), sortField);
        Pageable pageable = PageRequest.of(p_page, p_pageSize, sort/*, Sort.by("id").descending()*/);
        // Retreive users
        Page<User> users = userRepository.findAll(pageable);
        List<User> usersList = new ArrayList<>();
        users.forEach(usersList::add);
        // Retreive count
        long totalRecords = userRepository.count();
        // Return result
        return new PaginatedUserDTO(usersList, totalRecords);
    }

    @Override
    public List<RewardsStatsDTO> getRewardsStats() {
        List<RewardsStatsDTO> resultDTO = new ArrayList<>();
        List<RewardsStats> result = userRepository.getRewardsStats();
        for(RewardsStats curStat : result) {
            resultDTO.add(new RewardsStatsDTO(curStat.getReward(), curStat.getCount()));
        }
        return resultDTO;
    }

    public PaginatedUserDTO findAllPaginated(
            int p_page, int p_pageSize,
            String sortField, String sortOrder,
            HashMap<String, UserFilterDTO> filterMap) {
        Sort sort = new Sort(Sort.Direction.fromString(sortOrder), sortField);
        Pageable pageable = PageRequest.of(p_page, p_pageSize, sort/*, Sort.by("id").descending()*/);
        // Retreive users
        List<User> usersList = userRepository.findAllFiltered(pageable, filterMap);
        // Retreive count
        long totalRecords = userRepository.count(filterMap);
        // Return result
        return new PaginatedUserDTO(usersList, totalRecords);
    }

    @Override
    public List<UserDTO> findByHorodatageGreaterThan(Date horodatage) {
        List<UserDTO> resultat = new ArrayList<>();
        userRepository.findByHorodatageGreaterThan(horodatage).forEach(user -> {
            resultat.add(new UserDTO(user));
        });
        return resultat;
    }

    @Override
    public UserDTO saveUser(UserDTO p_userDto) {
        UserDTO resultat = null;
        User updatedUser = userRepository.save(p_userDto.toUser());
        if(updatedUser!=null) {
            resultat = new UserDTO(updatedUser);
        }
        return resultat;
    }

    @Override
    public UserDTO createUser(String p_login) {
        UserDTO resultat = null;

        User user = new User();
        user.setLogin(p_login);
        user.setPass("fake_user");
        user.setEloranking(1500);
        user.setIcone(iconeRepository.findByCodeIcone("NONE"));
        user.setIsABot(0);
        user.setLoses(0);
        user.setWins(0);
        User insertedUser = userRepository.save(user);

        if(insertedUser != null) {
            resultat = new UserDTO(insertedUser);
        }

        return resultat;
    }

    @Override
    public Integer getMaxId() {
        return userRepository.getMaxId();
    }
}
