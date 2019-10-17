package spring.service;

import org.springframework.stereotype.Service;
import spring.modal.Items;
import spring.modal.OrderHistory;

import java.util.List;

@Service
public interface OrderHistoryService {
    OrderHistory placeOrder(Long userid, Long itemsid,Double total,int quantity);
    List<OrderHistory> fetchOrders(Long userid);
}
