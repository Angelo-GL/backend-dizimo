package com.dizimo.backend_dizimo.service;

import com.dizimo.backend_dizimo.dto.MessageResposeDTO;
import com.dizimo.backend_dizimo.entities.Dizimista;
import com.dizimo.backend_dizimo.entities.User;
import com.dizimo.backend_dizimo.exceptions.UserNotFoundExceptions;
import com.dizimo.backend_dizimo.repositories.DizimistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public MessageResposeDTO updateDizimista (Dizimista dizimista){
        Optional<Dizimista> dizimistaFound = repository.findById(dizimista.getId());

        if(dizimistaFound.isPresent()){
            Dizimista dizUpdate = dizimistaFound.get();

            dizUpdate.setName(dizimista.getName());
            dizUpdate.setBairro(dizUpdate.getBairro());
            dizUpdate.setAtivo(dizimista.getAtivo());
            dizUpdate.setRua(dizimista.getRua());
            dizUpdate.setNumero(dizimista.getNumero());
            dizUpdate.setCelular(dizimista.getCelular());
            dizUpdate.setNascimento(dizimista.getNascimento());
            repository.save(dizUpdate);
            return new MessageResposeDTO("Update DIzimista Id" + dizimista.getId());
        }else {
            return new MessageResposeDTO("Not found Dizimista of Id " + dizimista.getId());
        }
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
