package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.modal.UsersList;
import spring.service.UsersListService;

import java.util.List;
@CrossOrigin("*")
@RestController
public class UsersListController {
    @Autowired
    private UsersListService usersListService;

    //get all users

    @GetMapping("/userslist")
    public ResponseEntity<List<UsersList>> list(){
        List<UsersList> list = usersListService.list();
        return ResponseEntity.ok().body(list);
    }
    @PostMapping("/register")
    public ResponseEntity<?> save(@RequestBody UsersList usersList){
        String username = usersListService.save(usersList);
        return ResponseEntity.ok().body("Registration Successful : Id is " + username );
    }
    @PostMapping("/user")
    public ResponseEntity<List<Object>>user(@RequestBody UsersList username){
        List<Object> l = usersListService.get(username.getEmail());
        return ResponseEntity.ok().body(l);
    }

}
