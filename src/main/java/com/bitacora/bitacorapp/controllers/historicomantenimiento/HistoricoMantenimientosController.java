package com.bitacora.bitacorapp.controllers.historicomantenimiento;

import com.bitacora.bitacorapp.domain.historicomantenimiento.HistoricoMantenimientosDomain;
import com.bitacora.bitacorapp.service.historicomantenimiento.HistoricoMantenimientosService;
import com.github.fge.jsonpatch.JsonPatch;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api")
public class HistoricoMantenimientosController {

    @Autowired
    private HistoricoMantenimientosService historicoMantenimientosService;

    @GetMapping("/historicomantenimientos")
    public ArrayList<HistoricoMantenimientosDomain>
    get(@RequestParam(required = true) String detalleMantenimiento) {
        return historicoMantenimientosService.get(detalleMantenimiento);
    }

    @GetMapping("/historicomantenimientos/all")
    public ArrayList<HistoricoMantenimientosDomain> get() {
        return historicoMantenimientosService.findAll();
    }

    @PostMapping("/historicomantenimientos")
    @ResponseStatus(HttpStatus.CREATED)
    public HistoricoMantenimientosDomain create(@RequestBody HistoricoMantenimientosDomain historico) {
        return historicoMantenimientosService.save(historico);
    }

    @PutMapping("/historicomantenimientos/{id}")
    public void update(@PathVariable("id") Long id,
                       @Valid @RequestBody HistoricoMantenimientosDomain historicomantenimientosDomain) {
        historicoMantenimientosService.update(id, historicomantenimientosDomain);
    }

    @PatchMapping(value = "/historicomantenimientos/{id}", consumes = "application/json-patch+json")
    public ResponseEntity<HistoricoMantenimientosDomain> patch(@PathVariable("id") Long id, @RequestBody JsonPatch patch) {
        return new ResponseEntity<>(historicoMantenimientosService.patch(id, patch), HttpStatus.OK);
    }

    @DeleteMapping("/historicomantenimientos/{id}")
    public void delete(@PathVariable("id") Long id) {
        historicoMantenimientosService.delete(id);
    }
}
