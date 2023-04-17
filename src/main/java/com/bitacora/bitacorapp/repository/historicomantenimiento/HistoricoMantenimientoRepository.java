package com.bitacora.bitacorapp.repository.historicomantenimiento;

import com.bitacora.bitacorapp.domain.empresa.EmpresaDomain;
import com.bitacora.bitacorapp.domain.historicomantenimiento.HistoricoMantenimientosDomain;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Date;

public interface HistoricoMantenimientoRepository  extends CrudRepository<HistoricoMantenimientosDomain, Long> {

    @Query(value = "SELECT h.id as id, h.idHistorico as idHistorico, h.detalleMantenimiento as detalleMantenimiento, " +
            "h.fechaEntrega as fechaEntrega,  h.fechaRecibido as fechaRecibido, "  +
            "h. idResponsable as idResponsable, h.idAutoriza as idAutoriza, h.idElabora as idElabora  FROM schema_bitacoapp_tbi_historias h " +
             "WHERE p.name like %?1%", nativeQuery = true)
    ArrayList<HistoricoMantenimientosDomain> findByMaintenanceDetail(String detalleMantenimiento);


    @Query(value = "SELECT count(1) FROM schema_bitacorapp.tbi_historias h WHERE h.detalleMantenimiento = ?1", nativeQuery = true)
    int countByMaintenanceDetail(String detalleMantenimiento);

    @Modifying
    @Query(value = "UPDATE schema_bitacorapp.tbi_historias SET idHistorico = ?1, detalleMantenimiento = ?2," +
            " fechaEntrega = ?3, fechaRecibido = ?4, idResponsable = ?5, idAutoriza  = ?6 , idElabora= ?7" +
            " modified_date = CURRENT_TIMESTAMP WHERE id = ?7", nativeQuery = true)
    void updateById(String detalleMantenimiento, Integer idHistorico, Date fechaEntrega, Date rechaRecibido, Integer idResponsable, Integer idAutoriza, Integer idEntrega, long id);




}
