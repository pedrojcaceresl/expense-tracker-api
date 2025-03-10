package com.smart.expense_tracker_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.smart.expense_tracker_api.dto.LoginUserDTO;
import com.smart.expense_tracker_api.dto.RegisterUserDTO;
import com.smart.expense_tracker_api.model.User;
import com.smart.expense_tracker_api.repository.UserRepository;

/**
 *
 * @author Pedro
 */
@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public User signup(RegisterUserDTO input) {
        User user = User.builder()
                .email(input.getEmail())
                .fullName(input.getFullname())
                .username(input.getUsername())
                .password(passwordEncoder.encode(input.getPassword()))
                .build();
        return userRepository.save(user);
    }

    public User authenticate(LoginUserDTO input) {
        User user = userRepository.findByEmailOrUsername(input.getIdentifier())
                .orElseThrow(() -> new UsernameNotFoundException("❌ Usuario no encontrado"));

        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(user.getEmail(), input.getPassword())
        );

        return user;
    }
}
