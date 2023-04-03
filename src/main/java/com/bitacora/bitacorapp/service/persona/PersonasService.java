package com.bitacora.bitacorapp.service.persona;


import com.bitacora.bitacorapp.domain.persona.PersonasDomain;
import com.bitacora.bitacorapp.repository.persona.PersonasRepository;
import com.bitacora.bitacorapp.util.Constants;
import com.bitacora.bitacorapp.util.UtilStrings;
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
        validationData(person);
        if (personasRepository.countByEmail(person.getEmail()) > 0) {
            throw new IllegalArgumentException("email already exits");
        }
        return personasRepository.save(person);
    }

    @Transactional
    public void update(Long id, PersonasDomain person) {
        validationData(person);
        if (personasRepository.findById(id).isEmpty()) throw new EntityNotFoundException();
        personasRepository.updateById(person.getName(), person.getEmail(), person.getCompanyId(),
                person.getPhone(), person.getSignature(), person.getUserType(), id);
    }

    @Transactional
    public void delete(Long id) {
        personasRepository.deleteById(id);
    }

    @Transactional
    public PersonasDomain patch(long id, JsonPatch patch) {
        return personasRepository.save(
                applyPatchToPerson(patch, personasRepository.findById(id)
                        .orElseThrow(EntityNotFoundException::new)));
    }

    private PersonasDomain applyPatchToPerson(JsonPatch patch, PersonasDomain person) {
        try {
            validationData(person);
            var objectMapper = new ObjectMapper();
            JsonNode patched = patch.apply(objectMapper.convertValue(person, JsonNode.class));
            return objectMapper.treeToValue(patched, PersonasDomain.class);
        } catch (JsonPatchException | JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void validationData(PersonasDomain personasDomain) {

        UtilStrings.requieresNoNullOrNoEmpty(personasDomain.getEmail(),
                String.format(Constants.TXT_EXPECT_VALUE, personasDomain.getEmail()));
        UtilStrings.requieresNoNullOrNoEmpty(personasDomain.getName(),
                String.format(Constants.TXT_EXPECT_VALUE, personasDomain.getName()));
        UtilStrings.requieresNoNullOrNoEmpty(personasDomain.getPhone(),
                String.format(Constants.TXT_EXPECT_VALUE, personasDomain.getPhone()));
        UtilStrings.requieresNoNullOrNoEmpty(personasDomain.getSignature(),
                String.format(Constants.TXT_EXPECT_VALUE, personasDomain.getSignature()));
        UtilStrings.requieresNoNullOrNoEmpty(personasDomain.getUserType(),
                String.format(Constants.TXT_EXPECT_VALUE, personasDomain.getUserType()));
        UtilStrings.requieresNoNullOrNoEmpty(personasDomain.getCompanyId().toString(),
                String.format(Constants.TXT_EXPECT_VALUE, personasDomain.getCompanyId().toString()));


        UtilStrings.requiresPattern(personasDomain.getCompanyId().toString(), Constants.TXT_PATTER_NUMBER,
                String.format(Constants.TXT_ONLY_NUMBERS, personasDomain.getCompanyId()));

        UtilStrings.requieresLength(personasDomain.getPhone().toString(), 10, 14,
                String.format(Constants.TXT_NO_LENGTH_REQUIERED, personasDomain.getPhone().toString()));
        UtilStrings.requiresPattern(personasDomain.getEmail(), Constants.TXT_PATTER_EMAIL,
                String.format(Constants.TXT_BAD_EMAIL, personasDomain.getEmail()));

    }



}
