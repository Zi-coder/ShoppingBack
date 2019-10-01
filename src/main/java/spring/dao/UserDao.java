package spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.modal.UserModel;
@Repository
public interface UserDao extends JpaRepository<UserModel,Long> {
    @Query("select u from UserModel u where u.username = ?1")
    UserModel findByEmailAddress(String emailAddress);
}
