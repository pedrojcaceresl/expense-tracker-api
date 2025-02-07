package com.smart.expense_tracker_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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


/**
 *
 * @author Pedro
 */
@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    
    @Autowired
    private final JwtService jwtService;

    @Autowired
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDTO registerUserDTO) {
        User registeredUser = authenticationService.signup(registerUserDTO);
        
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDTO loginUserDTO) {
        User authenticateduser = authenticationService.authenticate(loginUserDTO);
        
        String jwtToken = jwtService.generateToken(authenticateduser);

        LoginResponse loginResponse = LoginResponse.builder()
                                            .token(jwtToken)
                                            .expiresIn(jwtService.getExpirationTime())
                                            .build();
        return ResponseEntity.ok(loginResponse);
    }
    
    
}
