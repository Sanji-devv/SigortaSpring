package com.company.sigorta.service;

import com.company.sigorta.model.UserModel;
import com.company.sigorta.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService
{
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) { this.userRepository = userRepository; }

    public List<UserModel> getUsers() { return userRepository.findAll(); }

    public UserModel getUserById(Integer id) { return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found")); }

    public UserModel getUserByName(String name) { return userRepository.findByName(name).orElseThrow(() -> new RuntimeException("User not found")); }

    public UserModel getUserBySurname(String surname) { return userRepository.findBySurname(surname).orElseThrow(() -> new RuntimeException("User not found")); }

    public UserModel getUserByEmail(String email) { return userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found")); }

    public UserModel createUser(UserModel userModel) { return userRepository.save(userModel); }

    public UserModel updateUser(Integer id, UserModel userModel)
    {
        UserModel existingUser = getUserById(id);
        existingUser.setName(userModel.getName());
        existingUser.setSurname(userModel.getSurname());
        existingUser.setEmail(userModel.getEmail());
        return userRepository.save(existingUser);
    }

    public void deleteUser(Integer id) { userRepository.deleteById(id); }
}
