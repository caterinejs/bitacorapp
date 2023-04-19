package com.bitacora.bitacorapp.controllers.empresa;

import com.bitacora.bitacorapp.domain.empresa.EmpresaDomain;
import com.bitacora.bitacorapp.service.empresa.EmpresaService;
import com.github.fge.jsonpatch.JsonPatch;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api")

public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/empresa")
    public ArrayList<EmpresaDomain> get(@RequestParam(required = true) String nombre){
        return empresaService.get(nombre);
    }
    @GetMapping("/empresa/email")
    public EmpresaDomain getByEmail(@RequestParam(required = true) String email) {

        return empresaService.getByEmail(email);
    }
    @GetMapping("/empresa/all")
    public ArrayList<EmpresaDomain> get()  {
        return empresaService.findAll();
    }

    @PostMapping("/empresa")
    @ResponseStatus(HttpStatus.CREATED)
    public EmpresaDomain create(@RequestBody EmpresaDomain empresa) {
        return empresaService.save(empresa);
    }


    @PutMapping("/empresa/{id}")
    public void update(@PathVariable("id") Long id,
                       @Valid @RequestBody EmpresaDomain empresaDomain) {
        empresaService.update(id, empresaDomain);
    }

    @PatchMapping(value = "/empresa/{id}", consumes = "application/json-patch+json")
    public ResponseEntity<EmpresaDomain> patch(@PathVariable("id") Long id, @RequestBody JsonPatch patch) {
        return new ResponseEntity<>(empresaService.patch(id, patch), HttpStatus.OK);
    }

    @DeleteMapping("/empresa/{id}")
    public void delete(@PathVariable("id") Long id) {
        empresaService.delete(id);
     }
}
