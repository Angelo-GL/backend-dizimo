package com.dizimo.backend_dizimo.service;

import com.dizimo.backend_dizimo.dto.MessageResposeDTO;
import com.dizimo.backend_dizimo.dto.OfertaDTO;
import com.dizimo.backend_dizimo.entities.Dizimista;
import com.dizimo.backend_dizimo.entities.Oferta;
import com.dizimo.backend_dizimo.exceptions.EntityNotFoundException;
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

    public Oferta findByIdOferta (Long id) {
        return ofertaRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Entity NOT FOUND: Oferta not found!"));
    }

    public Oferta updateOferta (OfertaDTO ofertaDTO, Long id){
        Oferta findOferta = findByIdOferta(id);

        findOferta.setValue(ofertaDTO.getValue());
        findOferta.setObs(ofertaDTO.getObs());
        findOferta.setMesReferente(ofertaDTO.getMesReferente());
        return ofertaRepository.save(findOferta);
    }
    @Transactional
    public void deleteOferta (Long id){
        if(ofertaRepository.existsById(id)){
            Oferta oferta = ofertaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Oferta não encontrada"));
            Dizimista dizimista = oferta.getDizimista();
            dizimista.getOfertas().remove(oferta);
            ofertaRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Oferta não encontrada");
        }

    }

}
