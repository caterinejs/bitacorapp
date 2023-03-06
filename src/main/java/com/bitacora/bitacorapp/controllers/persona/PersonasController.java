package com.bitacora.bitacorapp.controllers.persona;


import com.bitacora.bitacorapp.domain.persona.PersonasDomain;
import com.bitacora.bitacorapp.service.persona.PersonasService;
import com.github.fge.jsonpatch.JsonPatch;
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

    @PutMapping("/personas/{id}")
    public void update(@PathVariable("id") Long id,
                       @Valid @RequestBody PersonasDomain personasDomain) {
        personasService.update(id, personasDomain);
    }

    @PatchMapping(value = "/personas/{id}", consumes = "application/json-patch+json")
    public ResponseEntity<PersonasDomain> patch(@PathVariable("id") Long id, @RequestBody JsonPatch patch) {
        return new ResponseEntity<>(personasService.patch(id, patch), HttpStatus.OK);
    }

    @DeleteMapping("/personas/{id}")
    public void delete(@PathVariable("id") Long id) {
        personasService.delete(id);
    }
}
