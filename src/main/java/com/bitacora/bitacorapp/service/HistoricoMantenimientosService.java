package com.bitacora.bitacorapp.service;


import com.bitacora.bitacorapp.domain.HistoricoMantenimientosDomain;
import com.bitacora.bitacorapp.repository.HistoricoMantenimientosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoricoMantenimientosService {

    @Autowired
    private HistoricoMantenimientosRepository historicoMantenimientosRepository;

    public static HistoricoMantenimientosDomain get(Integer idHistorical) {
        return historicoMantenimientosRepository.findByIdHistorical(idHistorical);
    }
    public static HistoricoMantenimientosDomain getAll() { return historicoMantenimientosRepository.findAll();}

    public static HistoricoMantenimientosDomain save(HistoricoMantenimientosDomain idHistorical) {
        return historicoMantenimientosRepository.save(idHistorical);
    }
    public static HistoricoMantenimientosDomain update(Integer idHistorical, HistoricoMantenimientosDomain historicoMantenimientosDomain){
        return historicoMantenimientosRepository.findByIdHistorical(idHistorical).flatMap(existingHistoricoMantenimientosDomain -> {
            existingHistoricoMantenimientosDomain.setMaintenanceDetail(
                    historicoMantenimientosDomain.getMaintenanceDetail().isEmpty() ? existingHistoricoMantenimientosDomain.getMaintenanceDetail() : historicoMantenimientosDomain.getMaintenanceDetail());
            existingHistoricoMantenimientosDomain.setDeliverDate(
                    historicoMantenimientosDomain.getDeliverDate().isEmpty() ? existingHistoricoMantenimientosDomain.getDeliverDate() : historicoMantenimientosDomain.getDeliverDate());
            existingHistoricoMantenimientosDomain.setDateReceived(
                    historicoMantenimientosDomain.getDateReceived().isEmpty() ? existingHistoricoMantenimientosDomain.getDateReceived() : historicoMantenimientosDomain.getDateReceived());
            existingHistoricoMantenimientosDomain.setIdResponsible(
                    historicoMantenimientosDomain.getIdResponsible().isEmpty() ? existingHistoricoMantenimientosDomain.getIdResponsible() : historicoMantenimientosDomain.getIdResponsible());
            existingHistoricoMantenimientosDomain.setIdAuthorizes(
                    historicoMantenimientosDomain.getIdAuthorizes().isEmpty() ?existingHistoricoMantenimientosDomain.getIdAuthorizes() :historicoMantenimientosDomain.getIdAuthorizes());
        });
    }
    public static Void delete(Integer idHistorical) {
        return HistoricoMantenimientosRepository.findByIdHistorical(idHistorical).flatMap(existingHistoricoMantenimientosDomain ->
                historicoMantenimientosRepository.deleteById(idHistorical));
    }

}
