package spring.dao;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.modal.Cart;
import spring.modal.Items;
import spring.modal.Users;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartDAO extends JpaRepository<Cart,Long> {

   Optional<Cart> findByUserAndItem(Users user, Items item);
   List<Cart> findAllByUser(Users users);
}
