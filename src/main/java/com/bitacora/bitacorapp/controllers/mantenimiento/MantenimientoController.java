package com.bitacora.bitacorapp.controllers.mantenimiento;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("app")

public class MantenimientoController {
/*
    @Autowired
    private MantenimientoService mantenimientoService;

    @GetMapping("/mantenimiento")
    public<MantenimientoDomain> get(@RequestParam(required = true) String zone){

        return mantenimientoService.get(zone);

    }
    @GetMapping("/mantenimienot/all")
    public <MantenimientoDomain> get()  {

        return mantenimientoService.getAll();
    }

    @PostMapping("/mantenimiento")
    public <MantenimientoDomain> create(@Valid @RequestBody MantenimientoDomain mantenimientoDomain) {

        return mantenimientoService.save(mantenimientoDomain);
    }

    @PutMapping("/mantenimiento")
    public <ResponseEntity<MantenimientoDomain>> update(@RequestParam(required = true) String mantenimientoDomainId,
                                                  @Valid @RequestBody MantenimientoDomain mantenimientoDomain){
        return mantenimientoService.update(mantenimientoDomainId, mantenimientoDomain).map(updateMantenimientoDomain -> new ResponseEntity<>
                (updateMantenimientoDomain, HttpStatus.OK)).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/mantenimiento")
    public <ResponseEntity<Void> delete (@RequestParam(required = true) String mantenimientoDomainId) {

        return mantenimientoService.delete(mantenimientoDomainId).then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                .defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
     }
*/
}
