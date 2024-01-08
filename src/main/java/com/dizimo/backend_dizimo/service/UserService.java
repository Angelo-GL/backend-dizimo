package com.dizimo.backend_dizimo.service;

import com.dizimo.backend_dizimo.dto.CredentialsDTO;
import com.dizimo.backend_dizimo.dto.UserDTO;
import com.dizimo.backend_dizimo.entities.Credentials;
import com.dizimo.backend_dizimo.entities.User;
import com.dizimo.backend_dizimo.exceptions.EntityConflict;
import com.dizimo.backend_dizimo.repositories.CredentialsRepository;
import com.dizimo.backend_dizimo.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CredentialsRepository credentialsRepository;


    public User createdUser (UserDTO userDTO){
        if(userRepository.existsByCpf(userDTO.getCpf())){
            throw new EntityConflict("CONFLICT: CPF já possui cadastrado!");
        }
        if(userRepository.existsByCelular(userDTO.getCelular())){
            throw new EntityConflict("CONFLICT: Celular já possui cadastrado!");
        }
        if(credentialsRepository.findBylogin(userDTO.getCredentials().getLogin()) != null){
            throw new EntityConflict("CONFLICT: Login já possui cadastro!");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(userDTO.getCredentials().getPassword());
        userDTO.getCredentials().setPassword(encryptedPassword);

        User user = new User();
        BeanUtils.copyProperties(userDTO, user);

        Credentials credentials = new Credentials();
        BeanUtils.copyProperties(userDTO.getCredentials(), credentials);

        // Associando as credenciais ao usuário
        user.setCredentials(credentials);

        User savedUser = userRepository.save(user);

        return savedUser;
    }
}
