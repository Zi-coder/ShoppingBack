package spring.modal;
import org.springframework.stereotype.Component;

import javax.persistence.*;
@Component
@Entity
public class UsersList {
    @Id
    private String email;
    private String fullname;
    private String password;

    public UsersList() {
    }

    public UsersList(String email, String fullname, String password) {
        this.email = email;
        this.fullname = fullname;
        this.password = password;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
