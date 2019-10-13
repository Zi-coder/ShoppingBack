package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.ItemsDAO;
import spring.modal.Items;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImplementation  implements ItemService{
    @Autowired
    ItemsDAO itemsDAO;
    @Override
    public List<Items> getAllItems() {
        return itemsDAO.findAll();
    }

    @Override
    public Items addItem(Items items) {
        return itemsDAO.save(items);
    }

    @Override
    public Optional<Items> itemDetails(Long id) {
       return itemsDAO.findById(id);
    }

    @Override
    public List<Items> filterCategory(String category) {
        return itemsDAO.findAllByCategory(category);
    }
}
