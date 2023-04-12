package com.dizimo.backend_dizimo.service;

import com.dizimo.backend_dizimo.dto.MessageResposeDTO;
import com.dizimo.backend_dizimo.entities.Dizimista;
import com.dizimo.backend_dizimo.repositories.DizimistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DizimistaService {

    @Autowired
    private DizimistaRepository repository;

    private MessageResposeDTO createDizimista (Dizimista dizimista){
        Dizimista saveDizimista = repository.save(dizimista);
        return createMessageResponse(saveDizimista.getId());
    }


    private MessageResposeDTO createMessageResponse(Long id) {
        return new MessageResposeDTO("Created Dizimista with ID" + id);
    }
}
