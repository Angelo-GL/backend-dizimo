package com.dizimo.backend_dizimo.service;

import com.dizimo.backend_dizimo.dto.MessageResposeDTO;
import com.dizimo.backend_dizimo.dto.UserDTO;
import com.dizimo.backend_dizimo.entities.User;
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
    public User createUser(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        return repository.save(user);
    }

    public List<User> findAllUser(){
        return repository.findAll();
    }

    public User findByIdUser(Long id) {
        return repository.findById(id).orElseThrow(()-> new EntityNotFoundException("id not found "+ id));
    }

    public MessageResposeDTO updateUser (User user){
        Optional<User> userFund = repository.findById(user.getId());

        if (userFund.isPresent()) {
            User userUpdate = userFund.get();
            userUpdate.setName(user.getName());
            userUpdate.setCpf(user.getCpf());
            userUpdate.setEmail(user.getEmail());
            userUpdate.setPassWord(user.getPassWord());
            repository.save(userUpdate);
            return new MessageResposeDTO("Update User Id" + user.getId());
        } else {
            return new MessageResposeDTO("Not found User of Id " + user.getId());
        }
    }

public boolean existsByCpf(String cpf){
        return repository.existsByCpf(cpf);
}

    private MessageResposeDTO createMessageResponse(UUID id) {
        return new MessageResposeDTO("Created User with ID" + id);
    }

}
