package spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.modal.OrderHistory;
import spring.modal.Users;

import java.util.List;

@Repository
public interface OrderHisatoryDAO extends JpaRepository<OrderHistory,Long> {
    List<OrderHistory> findAllByUsers(Users users);
}
