package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.Principal;

@Component
public class CurrentUserService {
    @Autowired
    UserService userService;


    public long getCurrentId( Principal principal){

        return  userService.findByEmailAddress(principal.getName()).getId();
    }

}
