package com.dizimo.backend_dizimo.service;

import com.dizimo.backend_dizimo.dto.MessageResposeDTO;
import com.dizimo.backend_dizimo.entities.Dizimista;
import com.dizimo.backend_dizimo.entities.User;
import com.dizimo.backend_dizimo.exceptions.UserNotFoundExceptions;
import com.dizimo.backend_dizimo.repositories.DizimistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DizimistaService {

    @Autowired
    private DizimistaRepository repository;

    public MessageResposeDTO createDizimista (Dizimista dizimista){
        Dizimista saveDizimista = repository.save(dizimista);
        return createMessageResponse(saveDizimista.getId());
    }

    public List<Dizimista> findAllDizimista(){
        return repository.findAll();
    }

    public Dizimista findByIdDizimista (Long id) throws UserNotFoundExceptions {
        return verifyIfExists(id);
    }



    private MessageResposeDTO createMessageResponse(Long id) {
        return new MessageResposeDTO("Created Dizimista with ID" + id);
    }

    private Dizimista verifyIfExists(Long id) throws UserNotFoundExceptions {
        return repository
                .findById(id)
                .orElseThrow(UserNotFoundExceptions::new);
    }
}
