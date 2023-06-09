package com.dizimo.backend_dizimo.controller;

import com.dizimo.backend_dizimo.dto.MessageResposeDTO;
import com.dizimo.backend_dizimo.entities.User;
import com.dizimo.backend_dizimo.exceptions.UserNotFoundExceptions;
import com.dizimo.backend_dizimo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResposeDTO createUser(@RequestBody @Valid User user){
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

    @PutMapping()
    public MessageResposeDTO UpdateUser (@RequestBody @Valid User user){
        return userService.updateUser(user);
    }

}
