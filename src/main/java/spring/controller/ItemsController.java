package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.modal.Items;
import spring.service.ItemService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/items")
public class ItemsController {
    @Autowired
    ItemService itemService;

    @GetMapping("/all")
    public List<Items> getAllItems(){
        return itemService.getAllItems();
    }
    @PostMapping("/addItem")
    public Items addItem(@RequestBody Items items){
        return itemService.addItem(items);

    }
    @GetMapping("/getDetail/{id}")
    public Optional<Items> getItemDetailById(@PathVariable(value = "id") Long id) {
        return itemService.itemDetails(id);
    }
}
