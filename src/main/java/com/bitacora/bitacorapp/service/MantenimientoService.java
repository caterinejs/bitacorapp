package com.bitacora.bitacorapp.service;


import com.bitacora.bitacorapp.repository.EmpresaRepository;
import com.bitacora.bitacorapp.repository.MantenimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MantenimientoService {

    @Autowired
    private MantenimientoRepository mantenimientoRepository;

    public <MantenimientoDomain> get(string zone) {

        return mantenimientoRepository.findByZone(zone);
    }

    public <MantenimientoDomain> getAll(){

        return mantenimientoRepository.findAll();
    }

    public <MantenimientoDomain> save(MantenimientoDomain zone) {

        return mantenimientoRepository.save(zone);
    }
    public <MantenimientoDomain> update(String zone, MantenimientoDomain mantenimientoDomain){
        return mantenimientoRepository.findByZone(zone).flatMap(existingMantenimientoDomain -> {
            existingMantenimientoDomain.setStartDate(
                    mantenimientoDomain.getStartDate().isEmpty() ? existingMantenimientoDomain.getStartDate() : mantenimientoDomain.getStartDate());
            existingMantenimientoDomain.setDeliverDate(
                    mantenimientoDomain.getDeliverDate().isEmpty() ? existingMantenimientoDomain.getDeliverDate() : mantenimientoDomain.getDeliverDate());
            existingMantenimientoDomain.setIdCommissionedCompany(
                    mantenimientoDomain.getIdCommissionedCompany().isEmpty() ? existingMantenimientoDomain.getIdCommissionedCompany() : mantenimientoDomain.getIdCommissionedCompany());
            existingMantenimientoDomain.setIdRequestingCompany(
                    mantenimientoDomain.getIdRequestingCompany().isEmpty() ? existingMantenimientoDomain.getIdRequestingCompany() : mantenimientoDomain.getIdRequestingCompany());
            existingMantenimientoDomain.setZone(
                    mantenimientoDomain.getZone().isEmpty() ? existingMantenimientoDomain.getZone() : mantenimientoDomain.getZone());
            existingMantenimientoDomain.setTypeOfMaintenance(
                    mantenimientoDomain.getTypeOfMaintenance().isEmpty() ? existingMantenimientoDomain.getTypeOfMaintenance() : mantenimientoDomain.getTypeOfMaintenance());


        });
    }
    public <Void> delete(String Zone){
        return mantenimientoRepository.findByZone(zone).flatMap(existingMantenimientoDomain ->
               mantenimientoRepository.deleteByZone(zone));
    }
}
