package spring.modal;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Cart implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Items item;
    @ManyToOne(fetch = FetchType.LAZY)
    private Users user;

    private int quantity;

    public Items getItem() {
        return item;
    }

    public void setItem(Items item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Cart() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
