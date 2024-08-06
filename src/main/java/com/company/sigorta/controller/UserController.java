package com.company.sigorta.controller;

import com.company.sigorta.model.UserModel;
import com.company.sigorta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController
{
    private final UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("/list_user")
    public List<UserModel> getUsers() { return userService.getUsers(); }

    @GetMapping("/user_id/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable Integer id)
    {
        try
        {
            UserModel user = userService.getUserById(id);
            return ResponseEntity.ok(user);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(404).body(null);
        }
    }

    @GetMapping("/user_name/{name}")
    public ResponseEntity<UserModel> getUserByName(@PathVariable String name)
    {
        try
        {
            UserModel user = userService.getUserByName(name);
            return ResponseEntity.ok(user);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(404).body(null);
        }
    }

    @GetMapping("/user_surname/{surname}")
    public ResponseEntity<UserModel> getUserBySurname(@PathVariable String surname)
    {
        try
        {
            UserModel user = userService.getUserBySurname(surname);
            return ResponseEntity.ok(user);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(404).body(null);
        }
    }

    @GetMapping("/user_email/{email}")
    public ResponseEntity<UserModel> getUserByEmail(@PathVariable String email)
    {
        try
        {
            UserModel user = userService.getUserByEmail(email);
            return ResponseEntity.ok(user);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(404).body(null);
        }
    }

    @PostMapping("/add_user")
    public ResponseEntity<UserModel> addUser(@RequestBody UserModel userModel)
    {
        try
        {
            UserModel createdUser = userService.createUser(userModel);
            return ResponseEntity.status(201).body(createdUser);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(400).body(null);
        }
    }

    @PutMapping("/update_user/{id}")
    public ResponseEntity<UserModel> updateUser(@PathVariable Integer id, @RequestBody UserModel userModel)
    {
        try
        {
            UserModel updatedUser = userService.updateUser(id, userModel);
            return ResponseEntity.ok(updatedUser);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(400).body(null);
        }
    }

    @DeleteMapping("/delete_user/{id}")
    public ResponseEntity<UserModel> deleteUser(@PathVariable Integer id)
    {
        try
        {
            UserModel userToDelete = userService.getUserById(id);
            userService.deleteUser(id);
            return ResponseEntity.ok(userToDelete);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(400).body(null);
        }
    }
}