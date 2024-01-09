package com.dizimo.backend_dizimo.service;

import com.dizimo.backend_dizimo.dto.AuthenticationDTO;

import com.dizimo.backend_dizimo.dto.LoginResponseDTO;
import com.dizimo.backend_dizimo.entities.Credentials;
import com.dizimo.backend_dizimo.entities.User;
import com.dizimo.backend_dizimo.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    TokenService tokenService;
    public LoginResponseDTO login (AuthenticationDTO authenticationDTO){
        var usernamePassword = new UsernamePasswordAuthenticationToken(authenticationDTO.login(), authenticationDTO.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((Credentials) auth.getPrincipal());
        return  new LoginResponseDTO(token);
   }
}
