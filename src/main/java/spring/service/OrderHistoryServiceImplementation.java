package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.OrderHisatoryDAO;
import spring.modal.Items;
import spring.modal.OrderHistory;
import spring.modal.Users;

import java.util.Date;
import java.util.List;

@Service
public class OrderHistoryServiceImplementation implements OrderHistoryService {
    @Autowired
    UserService userService;
    @Autowired
    ItemService itemService;

    @Autowired
    OrderHisatoryDAO orderHisatoryDAO;
    @Override
    public OrderHistory placeOrder(Long userid, Long itemsid,Double total,int quantity) {

        OrderHistory order = new OrderHistory();
        Users user  = userService.getUserById(userid);
        Items items = itemService.getById(itemsid);
        order.setUsers(user);
        order.setItems(items.toString());
        order.setTotal(total);
        order.setQuantity(quantity);
        order.setOrderDate(new Date());
        orderHisatoryDAO.save(order);
        return order;
    }

    @Override
    public List<OrderHistory> fetchOrders(Long userid) {
        Users user  = userService.getUserById(userid);
        return orderHisatoryDAO.findAllByUsers(user);
    }
}
