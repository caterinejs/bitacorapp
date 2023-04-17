package com.bitacora.bitacorapp.controllers.suscriptor;

import com.bitacora.bitacorapp.domain.historicomantenimiento.HistoricoMantenimientosDomain;
import com.bitacora.bitacorapp.domain.suscriptor.SuscriptorDomain;
import com.bitacora.bitacorapp.service.suscriptor.SuscriptorService;
import com.github.fge.jsonpatch.JsonPatch;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api")
public class SuscriptorController {

    @Autowired
    private SuscriptorService suscriptorService;

    @GetMapping("/suscriptor")
    public ArrayList<SuscriptorDomain> get(@RequestParam(required = true) String nombreUsuario) {
        return suscriptorService.get(nombreUsuario);
    }


    @GetMapping("/suscriptor/email")
    public SuscriptorDomain getByEmail(@RequestParam(required = true) String email) {
        return suscriptorService.getByEmail(email);
    }

    @GetMapping("/suscriptor/all")
    public ArrayList<SuscriptorDomain> get() {
        return suscriptorService.findAll();
    }
    @PostMapping("/suscriptor")
    @ResponseStatus(HttpStatus.CREATED)
    public SuscriptorDomain create(@RequestBody SuscriptorDomain suscriptor) {
        return suscriptorService.save(suscriptor);
    }

    @PutMapping("/suscriptor/{id}")
    public void update(@PathVariable("id") Long id,
                       @Valid @RequestBody SuscriptorDomain suscriptorDomain) {
        suscriptorService.update(id, suscriptorDomain);
    }

    @PatchMapping(value = "/suscriptor/{id}", consumes = "application/json-patch+json")
    public ResponseEntity<SuscriptorDomain> patch(@PathVariable("id") Long id, @RequestBody JsonPatch patch) {
        return new ResponseEntity<>(suscriptorService.patch(id, patch), HttpStatus.OK);
    }

    @DeleteMapping("/personas/{id}")
    public void delete(@PathVariable("id") Long id) {
        suscriptorService.delete(id);
    }
}
