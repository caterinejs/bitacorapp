package com.bitacora.bitacorapp.controllers.historicomantenimiento;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("app")

public class HistoricoMantenimientosController {
/*
    @Autowired
    private HistoricoMantenimientosService historicoMantenimientosService;

    @GetMapping("/historicomantenimientos")
    public HistoricoMantenimientosDomain get(@RequestParam( required = true) Integer idHistorical){

        return historicomantenimientosService.get(idHistorical);
    }

    @GetMapping("/historicomantenimientos/all")
    public HistoricoMantenimientosDomain get(){
        return historicoMantenimientosService.getAll();
    }

    @PostMapping("/historicomantenimientos")
    public HistoricoMantenimientosDomain create(@Valid @RequestBody HistoricoMantenimientosDomain historicoMantenimientosDomain) {

        return historicoMantenimientosService.save(historicoMantenimientosDomain);
    }

    @PutMapping("/historicomantenimientos")
    public ResponseEntity <HistoricoMantenimientosDomain> update(@RequestParam(required = true) Integer historicoMantenimientosDomainId,
                                                       @Valid @RequestBody historicoMantenimientosDomain historicoMantenimientoDomain){
        return historicoMantenimientosService.update(historicoMantenimientosDomainId, historicoMantenimientosDomain).map(updateHistoricoMantenimientosDomain -> new ResponseEntity<>(
                updateHistoricoMantenimientosDomain, HttpStatus.OK)).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/historicomantenimientos")
    public ResponseEntity<Void> delete (@RequestParam(required = true) Integer historicoMantenimientosDomainId) {

        return historicoMantenimientosService.delete(historicoMantenimientosDomainId).then(new ResponseEntity<Void>(HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.OK));
    }
*/
}
