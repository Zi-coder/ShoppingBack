package spring.dao;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.modal.UserDetails;

import javax.persistence.EntityManager;

@Repository
public class UserDetailsDAOImplement implements UserDetailsDAO {

    @Autowired
    private EntityManager entityManager;

    private Session getSession(){
        return entityManager.unwrap(Session.class);
    }
    @Override
    public String saveUserDetails(UserDetails userDetails) {
        getSession().save(userDetails);
        return userDetails.getUsername();
    }

    @Override
    public String getUserDetails(String username) {
        //Fetching Single Record from database Implementation
        return null;
    }
}
