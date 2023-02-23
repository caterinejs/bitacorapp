package com.bitacora.bitacorapp.service;


import com.bitacora.bitacorapp.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {
/*
    @Autowired
    private EmpresaRepository empresaRepository;

    public <EmpresaDomain> get(string name) {

        return empresaRepository.findByName(name);
    }

    public <EmpresaDomain> getAll(){

        return empresaRepository.findAll();
    }

    public <EmpresaDomain> save(ProductsDomain name) {

        return empresaRepository.save(name);
    }
    public <EmpresaDomain> update(String id, EmpresaDomain empresaDomain){
        return empresaRepository.findById(id).flatMap(existingEmpresaDomain -> {
            existingEmpresaDomain.setName(
                    empresaDomain.getName().isEmpty() ? existingEmpresaDomain.getName() : empresaDomain.getName());
            existingEmpresaDomain.setPhone(
                    empresaDomain.getPhone().isEmpty() ? existingEmpresaDomain.getPhone() : empresaDomain.getPhone());
            existingEmpresaDomain.setLegallyResponsible(
                    empresaDomain.getLegallyResponsible().isEmpty() ? existingEmpresaDomain.getLegallyResponsible() : empresaDomain.getLegallyResponsible());

        });
    }
    public <Void> delete(Integer id){
        return empresaRepository.findById(id).flatMap(existingEmpresaDomain ->
                empresaRepository.deleteById(id));
    }

 */
}
