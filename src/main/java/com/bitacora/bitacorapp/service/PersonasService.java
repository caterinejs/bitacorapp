package com.bitacora.bitacorapp.service;


import com.bitacora.bitacorapp.domain.PersonasDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bitacora.bitacorapp.repository.PersonasRepository;

@Service
public class PersonasService {

    @Autowired
    private PersonasRepository personasRepository;

    public static PersonasDomain get(String name) {
        return personasRepository.findByName(name);
    }
    public static PersonasDomain getAll() { return personasRepository.findAll();}

    public static PersonasDomain save(PersonasDomain name) {
        return personasRepository.save(name);
    }
    public static PersonasDomain update(String id, PersonasDomain personasDomain){
        return personasRepository.findById(id).flatMap(existingPersonasDomain -> {
            existingPersonasDomain.setName(
                    personasDomain.getName().isEmpty() ? existingPersonasDomain.getName() : personasDomain.getName());
            existingPersonasDomain.setPhone(
                    personasDomain.getPhone().isEmpty() ? existingPersonasDomain.getPhone() : personasDomain.getPhone());
            existingPersonasDomain.setSignature(
                    personasDomain.getSignature().isEmpty() ? existingPersonasDomain.getSignature() : personasDomain.getSignature());
            existingPersonasDomain.setcCompanyId(
                    personasDomain.getCompanyId().isEmpty() ? existingPersonasDomain.getCompanyId() : personasDomain.getCompanyId());
            existingPersonasDomain.setUserType(
                    personasDomain.getUserType().isEmpty() ? existingPersonasDomain.getUserType() : personasDomain.getUserType());
            existingPersonasDomain.setEmail(
                    personasDomain.getEmail().isEmpty() ? existingPersonasDomain.getEmail() : personasDomain.getEmail());
        });
    }
    public static Void delete(Integer id) {
        return PersonasRepository.findById(id).flatMap(existingPersonasDomain ->
                PersonasRepository.deleteById(id));
    }

}
