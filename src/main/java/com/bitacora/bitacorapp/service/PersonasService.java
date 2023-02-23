package com.bitacora.bitacorapp.service;


import com.bitacora.bitacorapp.domain.PersonasDomain;
import com.bitacora.bitacorapp.repository.PersonasRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Optional;

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
        if(personasRepository.countByEmail(person.getEmail()) > 0){
          throw new IllegalArgumentException("email already exits");
        }
        return personasRepository.save(person);
    }
     /*
    @Transactional
    public void update(Long id, PersonasDomain personasDomain){
         personasRepository.findById(id).flatMap(existingPersonasDomain -> {
            existingPersonasDomain.setName(
                    personasDomain.getName().isEmpty() ? existingPersonasDomain.getName() : personasDomain.getName());
            existingPersonasDomain.setPhone(
                    personasDomain.getPhone().isEmpty() ? existingPersonasDomain.getPhone() : personasDomain.getPhone());
            existingPersonasDomain.setSignature(
                    personasDomain.getSignature().isEmpty() ? existingPersonasDomain.getSignature() : personasDomain.getSignature());
            existingPersonasDomain.setCompanyId(
                    personasDomain.getCompanyId().equals(null) ? existingPersonasDomain.getCompanyId() : personasDomain.getCompanyId());
            existingPersonasDomain.setUserType(
                    personasDomain.getUserType().isEmpty() ? existingPersonasDomain.getUserType() : personasDomain.getUserType());
            existingPersonasDomain.setEmail(
                    personasDomain.getEmail().isEmpty() ? existingPersonasDomain.getEmail() : personasDomain.getEmail());
             personasRepository.save(existingPersonasDomain);
             return null;
         });
    }
    public static Void delete(Integer id) {
        return PersonasRepository.findById(id).flatMap(existingPersonasDomain ->
                PersonasRepository.deleteById(id));
    }
 */
}
