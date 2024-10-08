package com.company.sigorta.service;

import com.company.sigorta.dto.RegisterDto;
import com.company.sigorta.model.UserModel;
import com.company.sigorta.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
/*
    public void registerNewUser(RegisterDto registerDto) {
        UserModel user = new UserModel();
        user.setUserName(registerDto.getUsername());
        //user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setUserEmail(registerDto.getUserEmail());
        user.setFirstName(registerDto.getFirstName());
        user.setLastName(registerDto.getLastName());

        userRepository.save(user);
    }
*/
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public List<UserModel> getUsers() {
        return userRepository.findAll();
    }

    public UserModel getUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    /*
        public UserModel getUserByName(String name)
        {
            return userRepository.findByUserName(name);
        }

        public UserModel getUserByEmail(String email)
        {
            return userRepository.findByUserEmail(email);
        }
    */
    public UserModel createUser(UserModel userModel) {
        return userRepository.save(userModel);
    }

    public UserModel updateUser(Integer id, UserModel userModel) {
        UserModel existingUser = getUserById(id);
        existingUser.setUserName(userModel.getUsername());
        existingUser.setUserEmail(userModel.getUserEmail());
        return userRepository.save(existingUser);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

}
