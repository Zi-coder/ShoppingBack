package spring.modal;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Items implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String name;
    private double price;
    private String details;
    private String image;
    private String category;
    private String subCategory;


    public Items(){};

    public Items(String name, int price, String details, String image, String category, String subCategory, int active, ItemDetails itemDetails) {
        this.name = name;
        this.price = price;
        this.details = details;
        this.image = image;
        this.category = category;
        this.subCategory = subCategory;
        this.active = active;

    }


    @Column(nullable = false,columnDefinition = "int default '1'")
    private int active;



    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }



    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Items{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", details='" + details + '\'' +
                ", image='" + image + '\'' +
                ", category='" + category + '\'' +
                ", subCategory='" + subCategory + '\'' +
                ", active=" + active +
                '}';
    }
}
