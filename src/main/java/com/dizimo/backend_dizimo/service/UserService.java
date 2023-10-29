package com.dizimo.backend_dizimo.service;

import com.dizimo.backend_dizimo.dto.MessageResposeDTO;
import com.dizimo.backend_dizimo.dto.UserDTO;
import com.dizimo.backend_dizimo.entities.User;
import com.dizimo.backend_dizimo.exceptions.EntityConflict;
import com.dizimo.backend_dizimo.exceptions.EntityNotFoundException;
import com.dizimo.backend_dizimo.exceptions.UserNotFoundExceptions;
import com.dizimo.backend_dizimo.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.hibernate.validator.constraints.UUID;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Transactional
    public User createUser(UserDTO userDTO) throws EntityConflict {
        if(existsByCpf(userDTO.getCpf())){
            throw new EntityConflict("Conflict: CPF já possui cadastro");
        }else if(existsByName(userDTO.getName())){
            throw new EntityConflict("Conflict: Nome já possui cadastro");
        }else if(existsByEmail(userDTO.getEmail())){
            throw new EntityConflict("Conflict: E-mail já possui cadastro");
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDTO, user);
            return repository.save(user);
        }
    }

    public List<User> findAllUser(){
        return repository.findAll();
    }

    public User findByIdUser(Long id) {
        return repository.findById(id).orElseThrow(()-> new EntityNotFoundException("id not found "+ id));
    }

    public User updateUser (UserDTO userDTO){
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);

        User userFund = findByIdUser(user.getId());

        userFund.setName(user.getName());
        userFund.setCpf(user.getCpf());
        userFund.setEmail(user.getEmail());
        userFund.setPassWord(user.getPassWord());
        return repository.save(userFund);
    }

    public boolean existsByCpf(String cpf){
        return repository.existsByCpf(cpf);
    }

    public boolean existsByName(String name){
        return  repository.existsByName(name);
    }

    public boolean existsByEmail(String email){
        return  repository.existsByEmail(email);
    }


}
