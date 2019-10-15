package spring.controller;

import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.modal.Cart;
import spring.modal.Items;
import spring.modal.Users;
import spring.service.CartService;
import spring.service.CurrentUserService;
import spring.service.UserService;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/cart")
public class CartController {
    @Autowired
    CurrentUserService currentUserService;
    @Autowired
    CartService cartService;
    @Autowired
    UserService userService;

    @GetMapping(value = "/addProducts/{item-id}")
    public Cart addProduct(Principal principal, @PathVariable(value = "item-id")Long item_id){
          return cartService.addProduct(currentUserService.getCurrentId(principal),item_id);

    }
    @GetMapping("/fetchProduct")
    public List<Cart> showCart(Principal principal){
        Users users = userService.getUserById( currentUserService.getCurrentId(principal) );
        return cartService.findAllByUser(users);
    }
    @GetMapping("/quantity/item-id={item-id}&inc={inc}")
    public String updateQuantity(Principal principal,@PathVariable(value = "item-id")Long item_id,@PathVariable(value = "inc")Boolean inc){
      return  cartService.updateQuantity(currentUserService.getCurrentId(principal),item_id,inc);
    }
    @DeleteMapping("/deleteItem/{item-id}")
    public String deleteItem(Principal principal,@PathVariable(value = "item-id")Long item_id){
        return cartService.deleteItem(currentUserService.getCurrentId(principal),item_id);
    }
    @DeleteMapping("/clearCart")
    public String clearCart(Principal principal){
        return cartService.clearCart(currentUserService.getCurrentId(principal));
    }




}
