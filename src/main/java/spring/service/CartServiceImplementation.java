package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.CartDAO;
import spring.modal.Cart;
import spring.modal.Items;
import spring.modal.Users;

import java.util.List;
import java.util.Optional;
@Service
public class CartServiceImplementation implements CartService {

    @Autowired
    CartDAO cartDAO;

    @Autowired
    UserService userService;
    @Autowired
    ItemService itemService;


    @Override
    public List<Cart> findAllByUser(Users users) {
        return cartDAO.findAllByUser(users);
    }

    @Override
    public Cart addProduct(Long userid, Long itemid) {
        System.out.println("Bhai Cart Service me hu ..user id " + userid +" hai aur item id hai "+ itemid) ;
        Users user = userService.getUserById(userid);
        Items items = itemService.getById(itemid);
        if(cartDAO.findByUserAndItem(user,items).isPresent()){
            Cart cart = cartDAO.findByUserAndItem(user,items).get();
            cart.setQuantity(cart.getQuantity()+1);
           return cartDAO.save(cart);
        }
        else{
            Cart cart = new Cart();
            cart.setUser(user);
            cart.setItem(items);
            cart.setQuantity(1);
        return     cartDAO.save(cart);
        }



        }


}
