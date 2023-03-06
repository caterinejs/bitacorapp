package com.bitacora.bitacorapp.controllers.empresa;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("app")

public class EmpresaController {
/*
    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/empresa")
    public<EmpresaDomain> get(@RequestParam(required = true) String name){

        return empresaService.get(name);

    }
    @GetMapping("/empresa/all")
    public <EmpresaDomain> get()  {

        return empresaService.getAll();
    }

    @PostMapping("/empresa")
    public <EmpresaDomain> create(@Valid @RequestBody EmpresaDomain empresaDomain) {

        return empresaService.save(empresaDomain);
    }

    @PutMapping("/empresa")
    public <ResponseEntity<EmpresaDomain>> update(@RequestParam(required = true) Integer empresaDomainId,
                                                  @Valid @RequestBody EmpresaDomain empresaDomain){
        return empresaService.update(empresaDomainId, empresaDomain).map(updateEmpresaDomain -> new ResponseEntity<>
                (updateEmpresaDomain, HttpStatus.OK)).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/empresa")
    public <ResponseEntity<Void> delete (@RequestParam(required = true) Integer productosDomainId) {

        return empresaService.delete(empresaDomainId).then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                .defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
     }
*/
}
