package com.smart.expense_tracker_api.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.expense_tracker_api.dto.LoginUserDTO;
import com.smart.expense_tracker_api.dto.RegisterUserDTO;
import com.smart.expense_tracker_api.model.LoginResponse;
import com.smart.expense_tracker_api.model.User;
import com.smart.expense_tracker_api.service.AuthenticationService;
import com.smart.expense_tracker_api.service.JwtService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.slf4j.Logger;

/**
 *
 * @author Pedro
 */
@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationService authenticationService;


    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDTO registerUserDTO) {
        User registeredUser = authenticationService.signup(registerUserDTO);
        
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody LoginUserDTO loginUserDTO) {
        try {
            User authenticatedUser = authenticationService.authenticate(loginUserDTO);
        
            String jwtToken = jwtService.generateToken(authenticatedUser);

            LoginResponse loginResponse = LoginResponse.builder()
                    .token(jwtToken)
                    .expiresIn(jwtService.getExpirationTime())
                    .build();

            return ResponseEntity.ok(loginResponse);

        } catch (UsernameNotFoundException e) {
            logger.error("❌ Usuario no encontrado: {}", e.getMessage());
            return ResponseEntity.status(404).body("Usuario no encontrado");

        } catch (BadCredentialsException e) {
            logger.error("❌ Credenciales incorrectas: {}", e.getMessage());
            return ResponseEntity.status(401).body("Credenciales incorrectas");

        } catch (Exception e) {
            logger.error("❌ Error interno en autenticación: ", e);
            return ResponseEntity.internalServerError()
                    .body("Error interno del servidor. Intente nuevamente más tarde.");
        }
    }
    
}
