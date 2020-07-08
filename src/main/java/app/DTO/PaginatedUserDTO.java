package app.DTO;

import app.entity.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PaginatedUserDTO implements Serializable {

    private Long totalRecords = 0L;
    private List<UserDTO> users = new ArrayList<>();

    public PaginatedUserDTO(List<User> p_users, Long p_totalRecords) {
        if(p_users == null) {
            new PaginatedUserDTO();
        } else {
            for(User curUser : p_users) {
                users.add(new UserDTO(curUser));
            }
            this.totalRecords = p_totalRecords;
        }
    }

    public PaginatedUserDTO() {
        users = new ArrayList<>();
        this.totalRecords = 0L;
    }

    public Long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }
}
