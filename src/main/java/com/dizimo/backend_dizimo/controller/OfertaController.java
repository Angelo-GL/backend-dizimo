package com.dizimo.backend_dizimo.controller;

import com.dizimo.backend_dizimo.dto.MessageResposeDTO;
import com.dizimo.backend_dizimo.dto.OfertaDTO;
import com.dizimo.backend_dizimo.entities.Oferta;
import com.dizimo.backend_dizimo.exceptions.UserNotFoundExceptions;
import com.dizimo.backend_dizimo.service.OfertaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/oferta")
public class OfertaController {

    @Autowired
    private OfertaService ofertaService;

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Oferta> cadastrarOferta (@PathVariable Long id, @RequestBody @Valid OfertaDTO ofertaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ofertaService.createOferta(id, ofertaDTO));
    }

    @GetMapping
    public ResponseEntity<List<Oferta>> findAll (){
        return ResponseEntity.ok(ofertaService.findAllOfertas());
    }

    @PutMapping
    public MessageResposeDTO updateOferta (@RequestBody @Valid Oferta oferta){
        return ofertaService.updateOferta(oferta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Oferta> findById (@PathVariable Long id) throws UserNotFoundExceptions {
        return ResponseEntity.ok(ofertaService.findByIdOferta(id));
    }

    @DeleteMapping("/{id}")
    public void deleteOferta (@PathVariable Long id){
        ofertaService.deleteOferta(id);
    }
}
