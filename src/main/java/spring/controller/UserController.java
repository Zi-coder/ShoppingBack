package spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.Exception.ResourceNotFoundException;
import spring.dao.UserDao;
import spring.modal.UserModel;
import spring.service.UserService;
import spring.service.UserServiceImplementation;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    
//    Get all users
    @GetMapping("/users")
    public List<UserModel> getAllUsers(){
    return userService.getAllUsers();
    }
    
//Add user to db
    @PostMapping("/addUser")
    public UserModel addUser(@Valid @RequestBody UserModel userModel){
        return userService.addUser(userModel);

    }
    
//   Retrieve details of ine user
    @GetMapping("/user/{id}")
    public UserModel getUserById(@PathVariable(value = "id") Long user_id){
        return userService.getUserById(user_id);
    }
    
//update details of user

    @PutMapping("/updateUser/{id}")
    public UserModel updateUserDetails(@PathVariable(value = "id") Long user_id,
                           @Valid @RequestBody UserModel userDetails) {

        return userService.updateUserDetails(user_id, userDetails);
    }
//
@DeleteMapping("/deleteUser/{id}")
public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long Id) {

    return ResponseEntity.ok().body(userService.deleteNote(Id));
}
@PostMapping("/username")
public ResponseEntity<?> findByEmailAddress(@Valid @RequestBody UserModel user){

    return ResponseEntity.ok().body(userService.findByEmailAddress(user.getUsername()));
}
}