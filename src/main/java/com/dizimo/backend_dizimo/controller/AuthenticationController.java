package com.dizimo.backend_dizimo.controller;

import com.dizimo.backend_dizimo.dto.AuthenticationDTO;
import com.dizimo.backend_dizimo.dto.UserDTO;
import com.dizimo.backend_dizimo.entities.User;
import com.dizimo.backend_dizimo.service.AuthenticationService;
import com.dizimo.backend_dizimo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<Authentication> login (@RequestBody @Valid AuthenticationDTO dto){
        authenticationService.login(dto);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> registerUser (@RequestBody @Valid UserDTO userDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createdUser(userDTO));
    }





}
