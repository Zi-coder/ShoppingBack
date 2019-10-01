package spring.service;
import org.springframework.stereotype.Service;
import spring.modal.UserModel;
import java.util.List;

@Service
public interface UserService  {
    public List<UserModel> getAllUsers();
    public UserModel addUser( UserModel userModel);
    public UserModel getUserById(Long user_id);
    public UserModel updateUserDetails( Long user_id,UserModel userDetails);
    public String deleteNote( Long Id);
    public UserModel findByEmailAddress(String emailAddress);

}
