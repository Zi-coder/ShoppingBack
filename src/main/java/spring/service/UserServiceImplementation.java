package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.Exception.ResourceNotFoundException;
import spring.dao.UserDao;
import spring.modal.Users;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public List<Users> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public Users addUser(Users users) {
        return userDao.save(users);
    }

    @Override
    public Users getUserById(Long user_id) {
        return userDao.findById(user_id).orElseThrow( ()-> new ResourceNotFoundException("User","id",user_id));
    }

    @Override
    public Users updateUserDetails(Long user_id, Users userDetails) {
        Users users = userDao.findById(user_id)
                .orElseThrow(() -> new ResourceNotFoundException("UserModel", "id", user_id));
        users.setAddress(userDetails.getAddress());
        users.setContact(userDetails.getContact());
        users.setFullname(userDetails.getFullname());
        users.setGender(userDetails.getGender());
        users.setPhoto(userDetails.getPhoto());

        return userDao.save(users);
    }

    @Override
    public void deleteUser(Long id) {
         userDao.deleteById(id);
    }

    @Override
    public Users findByEmailAddress(String emailAddress) {
        return userDao.findByUsername(emailAddress);
    }

    @Override
    public String updateUser(Long id) {
        return null;
    }
}
