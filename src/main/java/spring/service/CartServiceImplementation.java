package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.CartDAO;
import spring.modal.Cart;
import spring.modal.Items;
import spring.modal.Users;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class CartServiceImplementation implements CartService {

    @Autowired
    CartDAO cartDAO;

    @Autowired
    UserService userService;
    @Autowired
    ItemService itemService;

    @Override
    public void deleteById(Long aLong) {
        cartDAO.deleteById(aLong);
    }



    @Override
    public String deleteItem(Long userid,Long itemid){
        Users user = userService.getUserById(userid);
        Items items = itemService.getById(itemid);
        Cart cart = cartDAO.findByUserAndItem(user,items).get();
        cartDAO.delete(cart);
        return "\"Deleted\"";

    }

    @Override
    public String clearCart(Long userid) {

        return cartDAO.deleteAllByUser(userService.getUserById(userid));
    }

    @Override
    public String updateQuantity(Long userid, Long itemid, boolean inc) {
        Users user = userService.getUserById(userid);
        Items items = itemService.getById(itemid);
        if(cartDAO.findByUserAndItem(user,items).isPresent() && inc==true){
            Cart cart = cartDAO.findByUserAndItem(user,items).get();
            cart.setQuantity(cart.getQuantity()+1);
            cartDAO.save(cart);
            return "\"Quantity Incremented\"";
        }
        else {
            Cart cart = cartDAO.findByUserAndItem(user,items).get();
            if(cart.getQuantity() > 0){
                cart.setQuantity(cart.getQuantity()-1);
                if(cart.getQuantity() == 0)
                    cartDAO.delete(cart);
                else
                cartDAO.save(cart);
            }

            return "\"Quantity Decremented\"";

        }
    }

    @Override
    public Cart addProduct(Long userid, Long itemid) {
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
    @Override
    public List<Cart> findAllByUser(Users users) {

        return cartDAO.findAllByUser(users);
    }


    @Override
    public List<Cart> findAllByItem(Items items) {
        return cartDAO.findAllByItem(items);
    }


}
