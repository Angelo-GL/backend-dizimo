package com.dizimo.backend_dizimo.controller;

import com.dizimo.backend_dizimo.dto.MessageResposeDTO;
import com.dizimo.backend_dizimo.entities.Oferta;
import com.dizimo.backend_dizimo.exceptions.UserNotFoundExceptions;
import com.dizimo.backend_dizimo.service.OfertaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ofetas")
public class OfertaController {

    @Autowired
    private OfertaService ofertaService;

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
