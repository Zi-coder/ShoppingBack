package spring.service;

import org.springframework.stereotype.Service;
import spring.modal.Cart;
import spring.modal.Items;
import spring.modal.Users;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public interface CartService {

    void deleteById(Long aLong);

    Cart addProduct(Long userid, Long itemid);

    String updateQuantity(Long userid, Long itemid,boolean inc);
    String deleteItem(Long userid,Long itemid);
    String clearCart(Long userid);

    List<Cart> findAllByItem(Items items);
    List<Cart> findAllByUser(Users user);
}
