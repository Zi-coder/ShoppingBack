package spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.modal.Users;
import spring.service.UserService;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

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

}