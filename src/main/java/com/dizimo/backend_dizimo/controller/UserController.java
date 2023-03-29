package com.dizimo.backend_dizimo.controller;

import com.dizimo.backend_dizimo.dto.MessageResposeDTO;
import com.dizimo.backend_dizimo.entities.User;
import com.dizimo.backend_dizimo.exceptions.UserNotFoundExceptions;
import com.dizimo.backend_dizimo.repositories.UserRepository;
import com.dizimo.backend_dizimo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResposeDTO createUser(@RequestBody @Validated User user){
        return userService.createUser(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll (){
        return ResponseEntity.ok(userService.findAllUser());
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> findById (@PathVariable Long id) throws UserNotFoundExceptions {
        User user = userService.findByIdUser(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/user")
    public MessageResposeDTO UpdateUser (@RequestBody @Validated User user){
        return userService.updateUser(user);
    }

}
