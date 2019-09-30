package spring.dao;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.modal.UsersList;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class UserListDAOImplementation implements UserListDAO{

    @Autowired
    private EntityManager entityManager;
//    @Autowired
//    private UsersList user;
    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }
    @Override
    public String save(UsersList usersList) {
        getSession().save(usersList );
        return  usersList.getEmail();
    }

    @Override
    public List<Object> get(String username) {
        return getSession().createQuery("FROM UsersList  WHERE email = :username").list();
    }

    @Override
    public List<UsersList> list() {
        List<UsersList> list = getSession().createQuery("from  UsersList").list();
        return list;
    }
}
