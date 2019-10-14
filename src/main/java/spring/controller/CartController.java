package spring.controller;

import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.modal.Cart;
import spring.modal.Items;
import spring.modal.Users;
import spring.service.CartService;
import spring.service.CurrentUserService;
import spring.service.UserService;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

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




}
