package spring.controller;


import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.modal.Users;
import spring.service.CurrentUserService;
import spring.service.UserService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    CurrentUserService currentUserService;

    @GetMapping("/getUser")
    public String getUser(){
        return "\"Successful Login\"";
    }
    @PostMapping("/addUser")
    public Users createUser(@Valid @RequestBody Users user){
        user.setActive(1);
        user.setRole("user");
        return userService.addUser(user);
    }
    @DeleteMapping(path = { "/deleteUser/{id}" })
    public String delete(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return "User Removed";
    }
    @GetMapping("/getUserDetails")
    public Users getDetail(Principal principal){
        System.out.println(principal.getName());
        System.out.println(userService.findByEmailAddress(principal.getName()).toString());
        return userService.findByEmailAddress(principal.getName());
    }

    @PostMapping("/update")
    public Users updateUser(@RequestBody Users users,Principal principal){
      return  userService.updateUserDetails(currentUserService.getCurrentId(principal),users);
    }
}