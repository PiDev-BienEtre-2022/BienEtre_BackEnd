package tn.esprit.happyemployee.controllers;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.happyemployee.entities.User;
import tn.esprit.happyemployee.security.services.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.happyemployee.entities.User;
import tn.esprit.happyemployee.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService agent;

    @GetMapping("/{id}")
    public User get_user(@PathVariable("id") long id){
        return agent.getUserById(id);
    }
	private final UserService userService;

	public UserController(UserService userService) {
        this.userService = userService;
    }


@GetMapping("/all")
public ResponseEntity<List<User>> getAllUsers () {
    List<User> users = userService.findAllUsers();
    return new ResponseEntity<>(users, HttpStatus.OK);
}

@GetMapping("/find/{id}")
public ResponseEntity<User> getUserById (@PathVariable("id") Long id) {
    User user = userService.findUserById(id);
    return new ResponseEntity<>(user, HttpStatus.OK);
}

@PostMapping("/add")
public ResponseEntity<User> addUser(@RequestBody User user) {
    User newUser = userService.addUser(user);
    return new ResponseEntity<>(newUser, HttpStatus.CREATED);
}

@PutMapping("/update")
public ResponseEntity<User> updateUser(@RequestBody User user) {
    User updateUser = userService.updateUser(user);
    return new ResponseEntity<>(updateUser, HttpStatus.OK);
}

@DeleteMapping("/delete/{id}")
public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
    userService.deleteUser(id);
    return new ResponseEntity<>(HttpStatus.OK);
}



}
