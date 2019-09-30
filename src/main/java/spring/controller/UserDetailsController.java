package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.modal.UserDetails;
import spring.service.UserDetailsService;

@CrossOrigin("*")
@RestController
public class UserDetailsController {
    @Autowired
    UserDetailsService userDetailsService;
    @GetMapping("/dummy")
    public ResponseEntity<String> resp(){

        return ResponseEntity.ok().body("Mapping Working");
    }
    @PostMapping("/userDetails")
    public ResponseEntity<?> save(@RequestBody UserDetails userDetails){
        String username = userDetailsService.saveUserDetails(userDetails);
        return ResponseEntity.ok().body("DetailsSaved Successful : Id is " + username );
    }
}
