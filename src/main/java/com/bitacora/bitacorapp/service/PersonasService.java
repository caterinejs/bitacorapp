package com.bitacora.bitacorapp.service;


import com.bitacora.bitacorapp.domain.PersonasDomain;
import com.bitacora.bitacorapp.repository.PersonasRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Locale;

@Service
public class PersonasService {

    @Autowired
    private PersonasRepository personasRepository;


    @Transactional
    public ArrayList<PersonasDomain> findAll() {
        return (ArrayList<PersonasDomain>) personasRepository.findAll();
    }

    @Transactional
    public ArrayList<PersonasDomain> get(String name) {
        return personasRepository.findByName(name.toUpperCase(Locale.ROOT));
    }

    @Transactional
    public PersonasDomain getByEmail(String email) {
        return personasRepository.findByEmail(email);
    }

    @Transactional
    public PersonasDomain save(PersonasDomain person) {
        if (personasRepository.countByEmail(person.getEmail()) > 0) {
            throw new IllegalArgumentException("email already exits");
        }
        return personasRepository.save(person);
    }

    @Transactional
    public void update(Long id, PersonasDomain personasDomain) {
        if (personasRepository.findById(id).isEmpty()) throw new EntityNotFoundException();
        personasRepository.updateById(personasDomain.getName(), personasDomain.getEmail(), personasDomain.getCompanyId(),
                personasDomain.getPhone(), personasDomain.getSignature(), personasDomain.getUserType(), id);
    }

    @Transactional
    public void delete(Long id) {
        personasRepository.deleteById(id);
    }

    @Transactional
    public PersonasDomain patch(long id, JsonPatch patch) {
        return personasRepository.save(
                applyPatchToProduct(patch, personasRepository.findById(id)
                        .orElseThrow(EntityNotFoundException::new)));
    }

    private PersonasDomain applyPatchToProduct(JsonPatch patch, PersonasDomain person) {
        try {
            var objectMapper = new ObjectMapper();
            JsonNode patched = patch.apply(objectMapper.convertValue(person, JsonNode.class));
            return objectMapper.treeToValue(patched, PersonasDomain.class);
        } catch (JsonPatchException | JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}
