package spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.modal.Users;
@Repository
public interface UserDao extends JpaRepository<Users,Long> {
//    @Query("select u.fullname,u.address,u.contact,u.gender,u.photo from Users u where u.username = ?1")
    Users findByUsername(String emailAddress);
}
