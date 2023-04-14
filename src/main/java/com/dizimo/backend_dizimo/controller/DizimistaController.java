package com.dizimo.backend_dizimo.controller;

import com.dizimo.backend_dizimo.dto.MessageResposeDTO;
import com.dizimo.backend_dizimo.entities.Dizimista;
import com.dizimo.backend_dizimo.exceptions.UserNotFoundExceptions;
import com.dizimo.backend_dizimo.service.DizimistaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/dizimistas")
public class DizimistaController {
    @Autowired
    private DizimistaService dizimistaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResposeDTO createDizimista(@RequestBody @Valid Dizimista dizimista){
        return dizimistaService.createDizimista(dizimista);
    }

    @GetMapping
    public ResponseEntity<List<Dizimista>> findAll () {
        return ResponseEntity.ok(dizimistaService.findAllDizimista());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dizimista> findById (@PathVariable Long id) throws UserNotFoundExceptions {
        return ResponseEntity.ok(dizimistaService.findByIdDizimista(id));
    }

    @PutMapping
    public MessageResposeDTO updateDizimista (@RequestBody @Valid Dizimista dizimista){
        return dizimistaService.updateDizimista(dizimista);
    }





}
