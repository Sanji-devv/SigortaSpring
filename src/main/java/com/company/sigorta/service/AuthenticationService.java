    package com.company.sigorta.service;

    import com.company.sigorta.dto.LoginDto;
    import com.company.sigorta.dto.RegisterDto;
    import com.company.sigorta.model.UserModel;
    import com.company.sigorta.repository.UserRepository;
    import lombok.RequiredArgsConstructor;
    import org.springframework.security.authentication.AuthenticationManager;
    import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
    import org.springframework.security.crypto.password.PasswordEncoder;
    import org.springframework.stereotype.Service;

    @Service
    @RequiredArgsConstructor
    public class AuthenticationService {
        private final UserRepository userRepository;
        private final PasswordEncoder passwordEncoder;
        private final AuthenticationManager authenticationManager;

        public UserModel signup(RegisterDto registerDto) {
            UserModel user = UserModel.builder()
                    .userName(registerDto.getUsername())
                    .password(passwordEncoder.encode(registerDto.getPassword()))
                    .userEmail(registerDto.getUserEmail())
                    .firstName(registerDto.getFirstName())
                    .lastName(registerDto.getLastName())
                    .build();
            return userRepository.save(user);
        }

        public UserModel authenticate(LoginDto loginDto) {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDto.getUsername(),
                            loginDto.getPassword()
                    )
            );
            return userRepository.findByUserName(loginDto.getUsername())
                    .orElseThrow();
        }
    }