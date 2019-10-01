package spring.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.Exception.ResourceNotFoundException;
import spring.dao.UserDao;
import spring.modal.UserModel;

import java.util.List;
import java.util.Queue;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public List<UserModel> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public UserModel addUser(UserModel userModel) {
        return userDao.save(userModel);
    }

    @Override
    public UserModel getUserById(Long user_id) {

        return userDao.findById(user_id).orElseThrow( ()-> new ResourceNotFoundException("User","id",user_id));
    }

    @Override
    public UserModel updateUserDetails(Long user_id, UserModel userDetails) {
        UserModel userModel = userDao.findById(user_id)
                .orElseThrow(() -> new ResourceNotFoundException("UserModel", "id", user_id));

        return userModel;
    }


    @Override
    public String deleteNote(Long Id) {
        UserModel userModel = userDao.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", Id));

        userDao.delete(userModel);

        return "Deleted Successfully";
    }

    @Override
    public UserModel findByEmailAddress(String emailAddress) {
        return userDao.findByEmailAddress(emailAddress);
    }
}
