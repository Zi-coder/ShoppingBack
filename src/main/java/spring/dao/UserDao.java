package spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.modal.UserModel;
@Repository
public interface UserDao extends JpaRepository<UserModel,Long> {
}
