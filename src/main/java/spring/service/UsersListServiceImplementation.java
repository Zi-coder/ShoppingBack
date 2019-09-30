package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.UserListDAO;
import spring.modal.UsersList;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UsersListServiceImplementation implements UsersListService {

    @Autowired
    private UserListDAO userListDAO;


    @Override
    @Transactional
    public String save(UsersList usersList) {
        return userListDAO.save(usersList);
    }

    @Override
    public List<Object> get(String username) {

        return userListDAO.get(username);
    }

    @Override
    @Transactional
    public List<UsersList> list() {
        return userListDAO.list();
    }
}
