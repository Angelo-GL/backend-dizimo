package com.dizimo.backend_dizimo.service;

import com.dizimo.backend_dizimo.dto.MessageResposeDTO;
import com.dizimo.backend_dizimo.entities.Dizimista;
import com.dizimo.backend_dizimo.entities.Oferta;
import com.dizimo.backend_dizimo.repositories.OfertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfertaService {
    @Autowired
    private OfertaRepository ofertaRepository;

    private MessageResposeDTO createOferta(Dizimista dizimista, Oferta oferta){
        oferta.setDizimista(dizimista);
        Oferta saveOferta = ofertaRepository.save(oferta);
        return createMessageResponse(saveOferta.getId());
    }

    private MessageResposeDTO createMessageResponse(Long id) {
        return new MessageResposeDTO("Created oferta with ID" + id);
    }
}
