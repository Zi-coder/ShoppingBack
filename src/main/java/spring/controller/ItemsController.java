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

    //getting all products
    @GetMapping("/all")
    public List<Items> getAllItems(){
        return itemService.getAllItems();
    }
    @GetMapping("/getDetail/{id}")
    public Optional<Items> getItemDetailById(@PathVariable(value = "id") Long id) {
        return itemService.itemDetails(id);
    }

    //getting items by category
    @GetMapping("/getItem/{cat}")
    public List<Items> getItemByCat(@PathVariable(value = "cat") String cat) {
        return itemService.filterCategory(cat);
    }

    //filter by price
    @GetMapping("filter/price/low={low}&high={high}")
    public List<Items> priceFilter(@PathVariable(value = "low")String low,@PathVariable(value = "high")String high){
        return itemService.findAllByPriceBetween(Double.parseDouble(low),Double.parseDouble(high));
    }

    //filter by brand
    @GetMapping("/filter/{brand}")
    public List<Items> brandFilter(@PathVariable(value = "brand")String brand){
        return itemService.filterBrand(brand);
    }

    //filter by brand and price
    @GetMapping("filter/combined/brand={brand}&low={low}&high={high}")
    public List<Items> combinedFilter(@PathVariable("brand")String brand,@PathVariable(value = "low")String low,@PathVariable(value = "high")String high){
        return itemService.filterByBrandAndPrice(brand,Double.parseDouble(low),Double.parseDouble(high));
    }

    //searching item by name
    @GetMapping("find/{name}")
    public List<Items> searchByName(@PathVariable(value = "name")String name){
        return itemService.searchByRegex(name);
    }


    //add item to database
    @PostMapping("/addItem")
    public Items addItem(@RequestBody Items items){
        return itemService.addItem(items);

    }

    //updating item details in database
    @PostMapping("/editItem")
    public Items editItem(@RequestBody Items items){
        return itemService.addItem(items);

    }


    //deleteing a product
    @DeleteMapping("/deleteProduct/{id}")

    public String deleteItem(@PathVariable(value = "id") Long id){
        return itemService.deleteItem(id);
    }
}
