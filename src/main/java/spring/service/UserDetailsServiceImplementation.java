package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.UserDetailsDAO;
import spring.modal.UserDetails;
import spring.modal.UsersList;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

    @Autowired
    UserDetailsDAO userDetailsDAO;

    @Override
    @Transactional
    public String saveUserDetails(UserDetails details) {
        return userDetailsDAO.saveUserDetails(details);
    }

    @Override
    public String getUserDetails(String username) {
        //To do fetch single record
        return null;
    }
}
