package spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.modal.Items;
@Repository
public interface ItemsDAO extends JpaRepository<Items,Long> {
}
