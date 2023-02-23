package com.bitacora.bitacorapp.controllers;


import com.bitacora.bitacorapp.domain.PersonasDomain;
import com.bitacora.bitacorapp.service.PersonasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api")
public class PersonasController {

    @Autowired
    private PersonasService personasService;

    @GetMapping("/personas")
    public ArrayList<PersonasDomain> get(@RequestParam(required = true) String name) {

        return personasService.get(name);
    }

    @GetMapping("/personas/email")
    public PersonasDomain getByEmail(@RequestParam(required = true) String email) {

        return personasService.getByEmail(email);
    }

    @GetMapping("/personas/all")
    public ArrayList<PersonasDomain> get() {
        return personasService.findAll();
    }

    @PostMapping("/personas")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonasDomain create(@RequestBody PersonasDomain person) {
        return personasService.save(person);
    }
    /*
    @PutMapping("/personas")
    public ResponseEntity<PersonasDomain> update(@RequestParam(required = true) Long personasDomainId,
                                                 @Valid @RequestBody PersonasDomain personasDomain){
        return personasService.update(personasDomainId, personasDomain).map(updatePersonasDomain -> new ResponseEntity<>(
                updatePersonasDomain, HttpStatus.OK)).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/personas")
    public ResponseEntity<Void> delete (@RequestParam(required = true) String personasDomainId) {

        return personasService.delete(personasDomainId).then(new ResponseEntity<Void>(HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.OK));
    }

*/


}
