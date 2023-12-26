package com.dizimo.backend_dizimo.controller;

import com.dizimo.backend_dizimo.dto.DizimistaDTO;
import com.dizimo.backend_dizimo.dto.MessageResposeDTO;
import com.dizimo.backend_dizimo.entities.Dizimista;
import com.dizimo.backend_dizimo.entities.Oferta;
import com.dizimo.backend_dizimo.exceptions.UserNotFoundExceptions;
import com.dizimo.backend_dizimo.service.DizimistaService;
import com.dizimo.backend_dizimo.service.OfertaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/dizimista/")
public class DizimistaController {
    @Autowired
    private DizimistaService dizimistaService;

    @Autowired
    private OfertaService ofertaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Dizimista> createDizimista(@RequestBody @Valid DizimistaDTO dizimistaDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(dizimistaService.createDizimista(dizimistaDTO));
    }

    @GetMapping
    public ResponseEntity<List<Dizimista>> findAll () {
        return ResponseEntity.ok(dizimistaService.findAllDizimista());
    }


    @PutMapping("{id}")
    public ResponseEntity<Dizimista> updateDizimista (@RequestBody @Valid DizimistaDTO dizimistaDTO, @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(dizimistaService.updateDizimista(dizimistaDTO, id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dizimista> findById (@PathVariable Long id){
        return ResponseEntity.ok(dizimistaService.findByIdDizimista(id));
    }


}
