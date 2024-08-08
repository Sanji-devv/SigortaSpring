package com.company.sigorta.controller;
import com.company.sigorta.dto.LoginDto;
import com.company.sigorta.model.UserModel;
import com.company.sigorta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list_user")
    public List<UserModel> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/user_id/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable Integer id) {
        UserModel user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }
    /*
        @GetMapping("/user_name/{name}")
        public ResponseEntity<UserModel> getUserByName(@PathVariable String name) {
            UserModel user = userService.getUserByName(name);
            return ResponseEntity.ok(user);
        }

        @GetMapping("/user_email/{email}")
        public ResponseEntity<UserModel> getUserByEmail(@PathVariable String email) {
            UserModel user = userService.getUserByEmail(email);
            return ResponseEntity.ok(user);
        }
    */
    @PostMapping("/add_user")
    public ResponseEntity<UserModel> createUser(@RequestBody UserModel userModel) {
        UserModel createdUser = userService.createUser(userModel);
        return ResponseEntity.status(201).body(createdUser);
    }

    @PutMapping("/update_user/{id}")
    public ResponseEntity<UserModel> updateUser(@PathVariable Integer id, @RequestBody UserModel userModel) {
        UserModel updatedUser = userService.updateUser(id, userModel);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/delete_user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}