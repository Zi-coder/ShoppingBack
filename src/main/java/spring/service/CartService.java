package spring.service;

import org.springframework.stereotype.Service;
import spring.modal.Cart;
import spring.modal.Items;
import spring.modal.Users;

import java.util.List;
import java.util.Optional;

@Service
public interface CartService {

    public Cart addProduct(Long userid, Long itemid);
    List<Cart> findAllByUser(Users user);
}
