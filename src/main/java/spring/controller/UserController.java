package spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.Exception.ResourceNotFoundException;
import spring.dao.UserDao;
import spring.modal.UserModel;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserDao userDao;
    
//    Get all users
    @GetMapping("/users")
    public List<UserModel> getAllUsers(){
    return userDao.findAll();
    }
    
//Add user to db
    @PostMapping("/addUser")
    public UserModel addUser(@Valid @RequestBody UserModel userModel){
        return userDao.save(userModel);
    }
    
//   Retrieve details of ine user
    @GetMapping("/user/{id}")
    public UserModel getUserById(@PathVariable(value = "id") Long user_id){
        return userDao.findById(user_id).orElseThrow( ()-> new ResourceNotFoundException("User","id",user_id));
    }
    
//update details of user

    @PutMapping("/notes/{id}")
    public UserModel updateUserModel(@PathVariable(value = "id") Long user_id,
                           @Valid @RequestBody UserModel userDetails) {

        UserModel userModel = userDao.findById(user_id)
                .orElseThrow(() -> new ResourceNotFoundException("UserModel", "id", user_id));

        return userModel;
    }
//
@DeleteMapping("/notes/{id}")
public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long Id) {
    UserModel userModel = userDao.findById(Id)
            .orElseThrow(() -> new ResourceNotFoundException("Note", "id", Id));

    userDao.delete(userModel);

    return ResponseEntity.ok().build();
}
}