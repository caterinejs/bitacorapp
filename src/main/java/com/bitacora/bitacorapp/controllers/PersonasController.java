package com.bitacora.bitacorapp.controllers;


import com.bitacora.bitacorapp.service.PersonasService;
import com.bitacora.bitacorapp.domain.PersonasDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("app")

public class PersonasController {

    @Autowired
    private PersonasService personasService;

    @GetMapping("/personas")
    public PersonasDomain get(@RequestParam( required = true) String name){

        return personasService.get(name);
    }

    @GetMapping("/personas/all")
    public PersonasDomain get(){
        return personasService.getAll();
    }

    @PostMapping("/personas")
    public PersonasDomain create(@Valid @RequestBody PersonasDomain personasDomain) {

        return personasService.save(personasDomain);
    }

    @PutMapping("/personas")
    public ResponseEntity <PersonasDomain> update(@RequestParam(required = true) String personasDomainId,
                                                       @Valid @RequestBody PersonasDomain personasDomain){
        return personasService.update(personasDomainId, personasDomain).map(updatePersonasDomain -> new ResponseEntity<>(
                updatePersonasDomain, HttpStatus.OK)).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/personas")
    public ResponseEntity<Void> delete (@RequestParam(required = true) String personasDomainId) {

        return personasService.delete(personasDomainId).then(new ResponseEntity<Void>(HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.OK));
    }






}
