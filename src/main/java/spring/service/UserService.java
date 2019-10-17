package spring.service;
import org.springframework.stereotype.Service;
import spring.modal.Users;
import java.util.List;

@Service
public interface UserService  {
    public List<Users> getAllUsers();
    public Users addUser(Users users);
    public Users getUserById(Long user_id);
    public Users updateUserDetails(Long user_id, Users userDetails);
    public void deleteUser(Long id);
    public Users findByEmailAddress(String emailAddress);

    String getRole(String username);

}
