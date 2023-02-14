package com.bitacora.bitacorapp.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("app")

public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/empresa")
    public<EmpresaDomain> get(@RequestParam(required = true) String name){

        return empresaService.get(name);

    }
    @GetMapping("/empresa/all")
    public <EmpresaDomainn> get()  {

        return empresaService.getAll();
    }

    @PostMapping("/empresa")
    public <EmpresaDomian> create(@Valid @RequestBody EmpresaDomian empresaDomian) {

        return empresaService.save(empresaDomian);
    }

    @PutMapping("/empresa")
    public <ResponseEntity<EmpresaDomain>> update(@RequestParam(required = true) String empresaDomainId,
                                                  @Valid @RequestBody EmpresaDomain empresaDomain){
        return empresaService.update(empresaDomainId, empresaDomain).map(updateEmpresaDomain -> new ResponseEntity<>
                (updateEmpresaDomain, HttpStatus.OK)).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/empresa")
    public <ResponseEntity<Void> delete (@RequestParam(required = true) String productosDomianId) {

        return empresaService.delete(empresaDomianId).then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                .defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
     }

}
