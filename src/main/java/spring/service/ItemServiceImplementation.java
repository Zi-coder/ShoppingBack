package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.Exception.ResourceNotFoundException;
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
    public Items editItem(Items items) {
        System.out.println("Got this product " + items.getName());
        Items item = itemsDAO.findById(items.getId()).orElseThrow(() -> new ResourceNotFoundException("ItemsModal", "id", items.getId()));
        item.setBrand(items.getBrand());
        item.setCategory(items.getCategory());
        item.setDescription(items.getDescription());
        item.setName(items.getName());
        item.setPrice(items.getPrice());
        item.setSeller(items.getSeller());
        item.setUrl(items.getUrl());
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

    @Override
    public List<Items> findAllByPriceBetween(double low, double high) {
        return itemsDAO.findAllByPriceBetween(low, high);
    }

    @Override
    public List<Items> searchByRegex(String reg) {
        return itemsDAO.findByNameContaining(reg);
    }

    @Override
    public Items getById(Long id) {
        System.out.println("ItemService me hu bhai...ye ID aayi hai " + id);
        return itemsDAO.findById(id).orElseThrow( ()-> new ResourceNotFoundException("User","id",id));
    }

    @Override
    public List<Items> filterBrand(String brand) {
        System.out.println("Item Service me ye brand aayya hai " + brand);
        return itemsDAO.findAllByBrand(brand);
    }

    @Override
    public List<Items> filterByBrandAndPrice(String brand, double low, double high) {
        return itemsDAO.findAllByBrandAndPriceBetween(brand, low, high);
    }
}
