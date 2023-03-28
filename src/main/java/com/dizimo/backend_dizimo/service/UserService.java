package com.dizimo.backend_dizimo.service;

import com.dizimo.backend_dizimo.dto.MessageResposeDTO;
import com.dizimo.backend_dizimo.entities.User;
import com.dizimo.backend_dizimo.exceptions.UserNotFoundExceptions;
import com.dizimo.backend_dizimo.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserService {
    private UserRepository repository;

    public MessageResposeDTO createUser(User user) {
        User saveUser = repository.save(user);
        return createMessageResponse(saveUser.getId());
    }

    public List<User> findAllUser(){
        return repository.findAll();
    }

    public User findByIdUser(long id) throws UserNotFoundExceptions {
        return verifyIfExists(id);
    }

    public MessageResposeDTO updateUser (User user) throws UserNotFoundExceptions {
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

    private MessageResposeDTO createMessageResponse(Long id) {
        return new MessageResposeDTO("Created User with ID" + id);
    }

    private User verifyIfExists(Long id) throws UserNotFoundExceptions {
        return repository
                .findById(id)
                .orElseThrow(UserNotFoundExceptions::new);
    }
}
