package spring.modal;

import javax.persistence.Embeddable;

@Embeddable
public class ItemDetails {
    private String detail;

    public ItemDetails(String detail) {
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
