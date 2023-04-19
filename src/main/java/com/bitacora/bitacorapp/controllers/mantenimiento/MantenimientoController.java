package com.bitacora.bitacorapp.controllers.mantenimiento;

import com.bitacora.bitacorapp.domain.mantenimiento.MantenimientoDomain;
import com.bitacora.bitacorapp.service.mantenimiento.MantenimientoService;
import com.github.fge.jsonpatch.JsonPatch;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api")

public class MantenimientoController {

    @Autowired
    private MantenimientoService mantenimientoService;

    @GetMapping("/mantenimiento")
    public ArrayList<MantenimientoDomain> get(@RequestParam(required = true) Integer numeroMantenimiento) {

        return mantenimientoService.get(numeroMantenimiento);
    }

    @GetMapping("/mantenimieto/idEmpresaSolicitante")
    public ArrayList<MantenimientoDomain> getByIdEmpresaSolicitante(@RequestParam(required = true) Integer idEmpresaSolicitante) {
        return mantenimientoService.getIdEmpresaSolicitante(idEmpresaSolicitante);
    }

    @GetMapping("/mantenimiento/all")
    public ArrayList<MantenimientoDomain> get() {
        return mantenimientoService.findAll();
    }


    @PostMapping("/mantenimiento")
    @ResponseStatus(HttpStatus.CREATED)
    public MantenimientoDomain create(@RequestBody MantenimientoDomain mantenimiento) {
        return mantenimientoService.save(mantenimiento);
    }

    @PutMapping("/mantenimiento/{id}")
    public void update(@PathVariable("id") Long id,
                       @Valid @RequestBody MantenimientoDomain mantenimientoDomain) {
        mantenimientoService.update(id, mantenimientoDomain);
    }

    @PatchMapping(value = "/mantenimiento/{id}", consumes = "application/json-patch+json")
    public ResponseEntity<MantenimientoDomain> patch(@PathVariable("id") Long id, @RequestBody JsonPatch patch) {
        return new ResponseEntity<>(mantenimientoService.patch(id, patch), HttpStatus.OK);
    }

    @DeleteMapping("/mantenimiento/{id}")
    public void delete(@PathVariable("id") Long id) {
        mantenimientoService.delete(id);
    }
}