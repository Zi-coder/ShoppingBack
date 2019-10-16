package spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.modal.Items;

import java.util.List;

@Repository
public interface ItemsDAO extends JpaRepository<Items,Long> {
    List<Items> findAllByCategory(String category);
    List<Items> findAllByPriceBetween(double low,double high);
    List<Items> findAllByBrand(String brand);
    List<Items> findAllByBrandAndPriceBetween(String brand,double low,double high);
    List<Items> findByNameContaining(String name);
}
