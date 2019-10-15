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
    @GetMapping("/getItem/{cat}")
    public List<Items> getItemByCat(@PathVariable(value = "cat") String cat) {
        return itemService.filterCategory(cat);
    }

    @GetMapping("filter/price/low={low}&high={high}")
    public List<Items> priceFilter(@PathVariable(value = "low")String low,@PathVariable(value = "high")String high){
        return itemService.findAllByPriceBetween(Double.parseDouble(low),Double.parseDouble(high));
    }
    @GetMapping("/filter/{brand}")
    public List<Items> brandFilter(@PathVariable(value = "brand")String brand){
        System.out.println("Controller me ye brand aaya hai + " + brand);
        return itemService.filterBrand(brand);
    }
    @GetMapping("filter/combined/brand={brand}&low={low}&high={high}")
    public List<Items> combinedFilter(@PathVariable("brand")String brand,@PathVariable(value = "low")String low,@PathVariable(value = "high")String high){
        return itemService.filterByBrandAndPrice(brand,Double.parseDouble(low),Double.parseDouble(high));
    }


}
