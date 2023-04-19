package com.bitacora.bitacorapp.repository.historicomantenimiento;

import com.bitacora.bitacorapp.domain.empresa.EmpresaDomain;
import com.bitacora.bitacorapp.domain.historicomantenimiento.HistoricoMantenimientosDomain;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Date;

public interface HistoricoMantenimientoRepository  extends CrudRepository<HistoricoMantenimientosDomain, Long> {

    @Query(value = "SELECT h.id as id, h.idHistoria as idHistoria, h.detalleMantenimiento as detalleMantenimiento, " +
            "h.fechaEntrega as fechaEntrega,  h.fechaRecibido as fechaRecibido, "  +
            "h. idResponsable as idResponsable, h.idAutoriza as idAutoriza, h.idElabora as idElabora  FROM schema_bitacoapp_tbi_historicos h " +
             "WHERE p.name like %?1%", nativeQuery = true)
    ArrayList<HistoricoMantenimientosDomain> findByMaintenanceDetail(String detalleMantenimiento);


    @Query(value = "SELECT count(1) FROM schema_bitacorapp.tbi_historias h WHERE h.detalle_mantenimiento = ?2", nativeQuery = true)
    int countByMaintenanceDetail(String detalleMantenimiento);

    @Modifying
    @Query(value = "UPDATE schema_bitacorapp.tbi_historicos SET id_historia = ?1, detalle_mantenimiento = ?2, fecha_entrega = ?3, fecha_recibido = ?4, id_responsable = ?5, id_autoriza  = ?6 , id_elabora= ?7,  modified_date = CURRENT_TIMESTAMP WHERE id = ?8", nativeQuery = true)
    void updateById(Integer idHistoria, String detalleMantenimiento, Date fechaEntrega, Date rechaRecibido, Integer idResponsable, Integer idAutoriza, Integer idEntrega, long id);

}
