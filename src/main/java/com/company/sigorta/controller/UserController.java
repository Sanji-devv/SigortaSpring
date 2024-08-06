package com.company.sigorta.controller;
import com.company.sigorta.model.UserModel;
import com.company.sigorta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController
{
    private final UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("/list_user")
    public List<UserModel> getUsers()
    {
        return userService.getUsers();
    }

    @GetMapping("/user_id/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable Integer id)
    {
        UserModel user = userService.getUserById(id);
        if (user != null)
        {
            return ResponseEntity.ok(user);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user_name/{name}")
    public ResponseEntity<UserModel> getUserByName(@PathVariable String name)
    {
        UserModel user = userService.getUserByName(name);
        if (user != null)
        {
            return ResponseEntity.ok(user);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user_email/{email}")
    public ResponseEntity<UserModel> getUserByEmail(@PathVariable String email)
    {
        UserModel user = userService.getUserByEmail(email);
        if (user != null)
        {
            return ResponseEntity.ok(user);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add_user")
    public ResponseEntity<UserModel> createUser(@RequestBody UserModel userModel)
    {
        UserModel createdUser = userService.createUser(userModel);
        return ResponseEntity.status(201).body(createdUser);
    }

    @PutMapping("/update_user/{id}")
    public ResponseEntity<UserModel> updateUser(@PathVariable Integer id, @RequestBody UserModel userModel)
    {
        UserModel updatedUser = userService.updateUser(id, userModel);
        if (updatedUser != null)
        {
            return ResponseEntity.ok(updatedUser);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete_user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id)
    {
        if (userService.getUserById(id) != null)
        {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
}