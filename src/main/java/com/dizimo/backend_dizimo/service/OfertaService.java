package com.dizimo.backend_dizimo.service;

import com.dizimo.backend_dizimo.dto.MessageResposeDTO;
import com.dizimo.backend_dizimo.dto.OfertaDTO;
import com.dizimo.backend_dizimo.entities.Dizimista;
import com.dizimo.backend_dizimo.entities.Oferta;
import com.dizimo.backend_dizimo.exceptions.UserNotFoundExceptions;
import com.dizimo.backend_dizimo.repositories.DizimistaRepository;
import com.dizimo.backend_dizimo.repositories.OfertaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OfertaService {
    @Autowired
    private OfertaRepository ofertaRepository;
    @Autowired
    private DizimistaService dizimistaService;

    @Transactional
    public Oferta createOferta(Long id, OfertaDTO ofertaDTO){
        Dizimista dizmista = dizimistaService.findByIdDizimista(id);

        ofertaDTO.setDate(LocalDate.now());

        Oferta oferta = new Oferta();
        BeanUtils.copyProperties(ofertaDTO, oferta);

        oferta.setDizimista(dizmista);
        return ofertaRepository.save(oferta);

    }

    public List<Oferta> findAllOfertas(){
        return ofertaRepository.findAll();
    }

    public Oferta findByIdOferta (Long id) throws UserNotFoundExceptions {
        return verifyIfExists(id);
    }

    public MessageResposeDTO updateOferta (Oferta oferta){
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

    public void deleteOferta (Long id){
        ofertaRepository.deleteById(id);
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
