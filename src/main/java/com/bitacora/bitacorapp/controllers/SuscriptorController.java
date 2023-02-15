package com.bitacora.bitacorapp.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("app")

public class SuscriptorController {

    @Autowired
    private SuscriptorService suscriptorService;

    @GetMapping("/suscriptor")
    public SuscriptorDomain get(@RequestParam( required = true) Integer id){

        return SuscriptorService.get(id);
    }

    @GetMapping("/suscriptor/all")
    public SuscriptorDomain get(){
        return suscriptorService.getAll();
    }

    @PostMapping("/suscriptor")
    public SuscriptorDomain create(@Valid @RequestBody SuscriptorDomain suscriptorDomain) {

        return suscriptorService.save(suscriptorDomain);
    }

    @PutMapping("/suscriptor")
    public ResponseEntity <SuscriptorDomain> update(@RequestParam(required = true) String SuscriptorDomainId,
                                                       @Validd @RequestBody SuscriptorDomain suscriptorDomain){
        return suscriptorService.update(suscriptorDomainId, suscriptorDomain).map(updateSuscriptorDomain -> new ResponseEntity<>(
                updateSuscriptorDomain, HttpStatus.OK)).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/suscriptor")
    public ResponseEntity<Void> delete (@RequestParam(required = true) String SuscriptorDomainId) {

        return suscriptorService.delete(suscriptorDomainId).then(new ResponseEntity<Void>(HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.OK));
    }






}
