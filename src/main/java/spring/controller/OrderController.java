package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.modal.Cart;
import spring.modal.OrderHistory;
import spring.service.CurrentUserService;
import spring.service.ItemService;
import spring.service.OrderHistoryService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    CurrentUserService currentUserService;

    @Autowired
    OrderHistoryService orderHistoryService;

    @Autowired
    ItemService itemService;

    @PostMapping("/placeOrder")
    public String placeOrder(@RequestBody Cart orders, Principal principal){
        System.out.println("Bhai controller me hu...ye list aayi hai");
        System.out.println(orders);
        double total = 0;
            total += orders.getItem().getPrice() * orders.getQuantity();
            orderHistoryService.placeOrder( currentUserService.getCurrentId(principal),orders.getItem().getId() ,total);
            System.out.println("Bhai ye maal Bhaeja hai -Itemid: "+ orders.getItem().getId() + " or total hua hai  " + total);
        return "\" Order Placed \"";
    }
    @GetMapping("/fetchOrders")
    public List<OrderHistory> fetchOrderForUser(Principal principal){

        return orderHistoryService.fetchOrders(currentUserService.getCurrentId(principal));
    }
}
