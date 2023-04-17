package com.dizimo.backend_dizimo.service;

import com.dizimo.backend_dizimo.dto.MessageResposeDTO;
import com.dizimo.backend_dizimo.entities.Dizimista;
import com.dizimo.backend_dizimo.entities.Oferta;
import com.dizimo.backend_dizimo.entities.User;
import com.dizimo.backend_dizimo.exceptions.UserNotFoundExceptions;
import com.dizimo.backend_dizimo.repositories.OfertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfertaService {
    @Autowired
    private OfertaRepository ofertaRepository;

    private MessageResposeDTO createOferta(Dizimista dizimista, Oferta oferta){
        oferta.setDizimista(dizimista);
        Oferta saveOferta = ofertaRepository.save(oferta);
        return createMessageResponse(saveOferta.getId());
    }

    private List<Oferta> findAllOfertas(){
        return ofertaRepository.findAll();
    }

    private Oferta findByIdOferta (Long id) throws UserNotFoundExceptions {
        return verifyIfExists(id);
    }

    private MessageResposeDTO updateOferta (Oferta oferta){
        Optional<Oferta> ofertaFound = ofertaRepository.findById(oferta.getId());

        if(ofertaFound.isPresent()){
            Oferta ofertaUpdate = ofertaFound.get();
            ofertaUpdate.setValue(oferta.getValue());
            ofertaUpdate.setMesReferente(oferta.getMesReferente());
            ofertaUpdate.setDate(oferta.getDate());
            ofertaUpdate.setObs(oferta.getObs());

            ofertaRepository.save(ofertaUpdate);

            return new MessageResposeDTO ("Update Oferta Id "+ oferta.getId());
        } return new MessageResposeDTO("Not found Oferta of Id " + oferta.getId());
    }


    private Oferta verifyIfExists(Long id) throws UserNotFoundExceptions {
        return ofertaRepository
                .findById(id)
                .orElseThrow(UserNotFoundExceptions::new);
    }

    private MessageResposeDTO createMessageResponse(Long id) {
        return new MessageResposeDTO("Created oferta with ID" + id);
    }
}
