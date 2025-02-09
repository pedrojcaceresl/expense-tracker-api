package com.smart.expense_tracker_api.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.smart.expense_tracker_api.model.User;
import com.smart.expense_tracker_api.repository.UserRepository;

/**
 *
 * @author Pedro
 */
@Service
public class CustomUserDetailsService implements UserDetailsService{
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String identifier) throws UsernameNotFoundException {
        User user = userRepository.findByEmailOrUsername(identifier)
            .orElseThrow(() -> new UsernameNotFoundException("User not found with email or username: " + identifier));

        // Retorna un objeto UserDetails con la información del usuario
        return new org.springframework.security.core.userdetails.User(
            user.getEmail(),
            user.getPassword(),
            user.getAuthorities()
        );
    }
}
