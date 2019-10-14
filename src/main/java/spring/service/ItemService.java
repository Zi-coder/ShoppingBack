package spring.service;

import org.springframework.stereotype.Service;
import spring.modal.Items;

import java.util.List;
import java.util.Optional;

@Service
public interface ItemService {
    public Items getById(Long id);
    public List<Items> getAllItems();
    public Items addItem(Items items);
    public Optional<Items> itemDetails(Long id);
    public List<Items>  filterCategory(String category);
    public List<Items> findAllByPriceBetween(double low,double high);
}
