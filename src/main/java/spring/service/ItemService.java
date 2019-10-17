package spring.service;

import org.springframework.stereotype.Service;
import spring.modal.Items;

import java.util.List;
import java.util.Optional;

@Service
 public interface ItemService {
     Items           getById(Long id);
     List<Items>     getAllItems();
     Items           addItem(Items items);
     Optional<Items> itemDetails(Long id);
     List<Items>     filterCategory(String category);
     List<Items>     findAllByPriceBetween(double low,double high);
     List<Items>     filterBrand(String brand);
     List<Items>     filterByBrandAndPrice(String brand,double low,double high);
     Items           editItem(Items items);
     List<Items>     searchByRegex(String reg);
     String                deleteItem(Long id);

    
}
