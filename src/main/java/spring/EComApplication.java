package spring;

import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import spring.modal.UsersList;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class EComApplication {

	public static void main(String[] args) {
		SpringApplication.run(EComApplication.class, args);
		SessionFactory sessionFactory ;
		UsersList u1 = new UsersList("akay@gmail.com","Anil","1234");


	}

}
