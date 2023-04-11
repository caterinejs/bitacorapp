package com.bitacora.bitacorapp.repository.historicomantenimiento;

import com.bitacora.bitacorapp.domain.historicomantenimiento.HistoricoMantenimientosDomain;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;

@Repository
public interface HistoricoMantenimientosRepository extends CrudRepository<HistoricoMantenimientosDomain, Long>
{
    @Query(value = "SELECT p.id as id, p.idHistorical as idHistorical, " +
            "p.maintenanceDetail as maintenanceDetail, p.deliverDate as deliverDate, " +
            "p.dateReceived as dateReceived, p.idResponsible as idResponsible," +
            " p.idAuthorizes as idAuthorizes, + FROM schema_bitacorapp.tbi_historicos p " +
            "WHERE p.name like %?1%", nativeQuery = true)
    ArrayList<HistoricoMantenimientosDomain> findByMaintenanceDetail(String maintenanceDetail);

    @Modifying
    @Query(value = "UPDATE schema_bitacorapp.tbi_historicos SET maintenanceDetail = ?1, deliverDate = ?2, dateReceived = ?3, idResponsible = ?4, idAuthorizes = ?5 , idHistorical = ?6" +
            " modified_date = CURRENT_TIMESTAMP WHERE id = ?7", nativeQuery = true)
    void updateById(String maintenanceDetail, Integer idHistorical, Date deliverDate, Date dateReceived, Integer idResponsible, Integer idAuthorizes, long id);

}

