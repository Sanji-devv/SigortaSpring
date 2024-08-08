package com.company.sigorta.controller;

import com.company.sigorta.dto.JwtResponseDTO;
import com.company.sigorta.dto.LoginDto;
import com.company.sigorta.dto.RegisterDto;
import com.company.sigorta.model.UserModel;
import com.company.sigorta.service.AuthenticationService;
import com.company.sigorta.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;
    private final JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<UserModel> register(@RequestBody RegisterDto registerDto) {
        UserModel registeredUser = authenticationService.signup(registerDto);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponseDTO> authenticate(@RequestBody LoginDto loginUserDto) {
        UserModel authenticatedUser = authenticationService.authenticate(loginUserDto);
        String jwtToken = jwtService.generateToken(authenticatedUser);
        JwtResponseDTO loginResponse = JwtResponseDTO.builder().accessToken(jwtToken).build();
        return ResponseEntity.ok(loginResponse);
    }
}