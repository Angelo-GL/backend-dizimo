package com.dizimo.backend_dizimo.controller;

import com.dizimo.backend_dizimo.dto.MessageResposeDTO;
import com.dizimo.backend_dizimo.entities.Dizimista;
import com.dizimo.backend_dizimo.service.DizimistaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/dizimista")
public class DizimistaController {
    @Autowired
    private DizimistaService dizimistaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResposeDTO createDizimista(@RequestBody @Valid Dizimista dizimista){
        return dizimistaService.createDizimista(dizimista);
    }


}
