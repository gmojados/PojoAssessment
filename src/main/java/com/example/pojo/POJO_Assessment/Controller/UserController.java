package com.example.pojo.POJO_Assessment.Controller;


import com.example.pojo.POJO_Assessment.Model.User;
import com.example.pojo.POJO_Assessment.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/users")
    public ResponseEntity<?> createCustomer (@Validated @RequestBody User user){
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);

    }
    @GetMapping(value = "/users/{userId}")
    public ResponseEntity<?> getUserById (@PathVariable Long userId){
        userService.getUserById(userId);
        return new ResponseEntity<>( HttpStatus.OK);
    }
    @DeleteMapping(value = "/users/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @RequestMapping(value = "/user/{userId}")
    public ResponseEntity<?> updateUser (@RequestBody User user, @PathVariable Long userID){
        userService.updateUser(user, userID);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

}
