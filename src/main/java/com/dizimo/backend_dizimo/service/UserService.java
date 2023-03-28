package com.dizimo.backend_dizimo.service;

import com.dizimo.backend_dizimo.dto.MessageResposeDTO;
import com.dizimo.backend_dizimo.entities.User;
import com.dizimo.backend_dizimo.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserService {
    private UserRepository repository;

    public MessageResposeDTO createUser(User user) {
        //Adicionar validações

        User saveUser = repository.save(user);
        return createMessageResponse(saveUser.getId());
    }

    public List<User> findAllUser(){
        return repository.findAll();
    }

    public User findByIdUser(long id){
        return repository.findById(id).orElse(null);
    }

    public MessageResposeDTO updateUser (User user){
       /* Optional<User> userFund = repository.findById(user.getId());

        if (userFund.isPresent()){
            User userUpdate = userFund.get();


        }*/
    }
    private MessageResposeDTO createMessageResponse(Long id) {
        return new MessageResposeDTO("Created User with ID" + id);
    }
}
