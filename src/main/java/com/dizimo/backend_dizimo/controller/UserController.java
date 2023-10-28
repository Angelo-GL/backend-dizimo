package com.dizimo.backend_dizimo.controller;

import com.dizimo.backend_dizimo.dto.MessageResposeDTO;
import com.dizimo.backend_dizimo.dto.UserDTO;
import com.dizimo.backend_dizimo.entities.User;
import com.dizimo.backend_dizimo.exceptions.UserNotFoundExceptions;
import com.dizimo.backend_dizimo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> createUser(@RequestBody @Valid UserDTO userDTO){
        if(userService.existsByCpf(userDTO.getCpf())){
            return  ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: CPF já possui cadastro");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userDTO));
    }


    @GetMapping
    public ResponseEntity<List<User>> findAll (){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAllUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById (@PathVariable Long id) {
        User user = new User();
        user = userService.findByIdUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PutMapping()
    public MessageResposeDTO UpdateUser (@RequestBody @Valid User user){
        return userService.updateUser(user);
    }
}
