package com.dizimo.backend_dizimo.service;

import com.dizimo.backend_dizimo.dto.DizimistaDTO;
import com.dizimo.backend_dizimo.dto.MessageResposeDTO;
import com.dizimo.backend_dizimo.entities.Dizimista;
import com.dizimo.backend_dizimo.exceptions.EntityConflict;
import com.dizimo.backend_dizimo.exceptions.EntityNotFoundException;
import com.dizimo.backend_dizimo.exceptions.UserNotFoundExceptions;
import com.dizimo.backend_dizimo.repositories.DizimistaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DizimistaService {
    @Autowired
    private DizimistaRepository repository;
    @Transactional
    public Dizimista createDizimista (DizimistaDTO dizimistaDTO) throws EntityConflict{
        if(existsByName(dizimistaDTO.getName())){
            throw new EntityConflict("CONFLICT: Nome já cadastrado!");
        }
        dizimistaDTO.setAtivo(true);
        Dizimista dizimista = new Dizimista();
        BeanUtils.copyProperties(dizimistaDTO, dizimista);
        return repository.save(dizimista);
    }

    public List<Dizimista> findAllDizimista(){
        return repository.findAll();
    }

    public Dizimista findByIdDizimista (Long id) {
        return repository.findById(id).orElseThrow(()-> new EntityNotFoundException("ENTITY_NOT_FUND: Dizimista not found!"));
    }

    public Dizimista updateDizimista (DizimistaDTO dizimistaDTO){
        Dizimista dizimista = new Dizimista();
        BeanUtils.copyProperties(dizimistaDTO, dizimista);

        Dizimista findDizimista = findByIdDizimista(dizimista.getId());

        findDizimista.setName(dizimista.getName());
        findDizimista.setBairro(dizimista.getBairro());
        findDizimista.setAtivo(dizimista.getAtivo());
        findDizimista.setRua(dizimista.getRua());
        findDizimista.setNumero(dizimista.getNumero());
        findDizimista.setCelular(dizimista.getCelular());
        findDizimista.setNascimento(dizimista.getNascimento());
        return repository.save(findDizimista);
    }

    boolean existsByName(String name){
        return repository.existsByName(name);
    }

}
