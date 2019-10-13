package spring.service;

import org.springframework.stereotype.Service;
import spring.modal.Items;

import java.util.List;
import java.util.Optional;

@Service
public interface ItemService {
    public List<Items> getAllItems();
    public Items addItem(Items items);
    public Optional<Items> itemDetails(Long id);
}
