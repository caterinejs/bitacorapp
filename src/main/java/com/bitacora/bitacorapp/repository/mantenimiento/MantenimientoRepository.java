package com.bitacora.bitacorapp.repository.mantenimiento;

import com.bitacora.bitacorapp.domain.mantenimiento.MantenimientoDomain;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Date;

public interface MantenimientoRepository extends CrudRepository<MantenimientoDomain, Long> {

    @Query(value = "SELECT m.id as id, m.numeroMantenimiento as numeroMantenimiento, m.fechaInicio as fechaInicio, " +
                    "m.fechaEntrega as fechaEntrega, m.idEmpresaEncargada as idEmpresaEncargada, " +
                    "m.idEmpresaSolicitante as idEmpresaSolicitante, m.zona as zona, " + "" +
                    "m.tipoDeMantenimiento as TipoDeMantenimiento FROM schema_bitacorapp.tbi_mantenimientos m" +
                    "WHERE m.numeroMantenimiento like %?1%", nativeQuery = true)
    ArrayList<MantenimientoDomain> findByNumeroMantenimiento(Integer numeroMantenimiento);

    @Query(value = "SELECT m.id as id, m.numeroMantenimiento as numeroMantenimiento, m.fechaInicio as fechaInicio, " +
            "m.fechaEntrega as fechaEntrega, m.idEmpresaEncargada as idEmpresaEncargada, " +
            "m.idEmpresaSolicitante as idEmpresaSolicitante, m.zona as zona, " + "" +
            "m.tipoDeMantenimiento as TipoDeMantenimiento FROM schema_bitacorapp.tbi_mantenimientos m" +
            "WHERE m.idEmpresaEncargada like %?1%", nativeQuery = true)
    ArrayList<MantenimientoDomain> findByIdEmpresaEncargada(Integer idEmpresaEncargada);

    @Query(value = "SELECT m.id as id, m.numeroMantenimiento as numeroMantenimiento, m.fechaInicio as fechaInicio, " +
            "m.fechaEntrega as fechaEntrega, m.idEmpresaEncargada as idEmpresaEncargada, " +
            "m.idEmpresaSolicitante as idEmpresaSolicitante, m.zona as zona, " + "" +
            "m.tipoDeMantenimiento as TipoDeMantenimiento FROM schema_bitacorapp.tbi_mantenimientos m" +
            "WHERE m.idEmpresaSolicitante like %?1%", nativeQuery = true)
    ArrayList<MantenimientoDomain> findByIdEmpresaSolicitante(Integer idEmpresaSolicitante);

    @Modifying
    @Query(value = "UPDATE schema_bitacorapp.tbi_mantenimientos SET numeroMantenimiento =?1, fechaInicio =?2, fechaEntrega =?3, idEmpresaEncargada =?4, idEmpresaSolicitante =?5, zona =?6, tipoDeMantenimiento =?7, modified_date = CURRENT_TIMESTAMP WHERE id =?8", nativeQuery = true )
    void updateById(Integer numeroMnatenimiento, Date fechaEntrega, Date fechaIngreso, Integer idEmpresaSolicitante, Integer idEmpresaEncargada, String Zona, String tipoMantenimiento, Long id);



}

