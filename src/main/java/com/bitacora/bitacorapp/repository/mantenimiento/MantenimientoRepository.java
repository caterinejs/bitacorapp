package com.bitacora.bitacorapp.repository.mantenimiento;

import com.bitacora.bitacorapp.domain.mantenimiento.MantenimientoDomain;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Date;

public interface MantenimientoRepository extends CrudRepository<MantenimientoDomain, Long> {

    @Query(value = "SELECT m.id as id, m.numeroMantenimiento as numeroMantenimiento, m.fechaInicio as fechaInicio, m.fechaEntrega as fechaEntrega, m.idEmpresaEncargada as idEmpresaEncargada, m.idEmpresaSolicitante as idEmpresaSolicitante, m.zona as zona, m.tipoDeMantenimiento as TipoDeMantenimiento FROM schema_bitacorapp.tbi_mantenimientos m" +
                    "WHERE m.numeroMantenimiento like %?1%", nativeQuery = true)
    ArrayList<MantenimientoDomain> findByNumeroMantenimiento(Integer numeroMantenimiento);


    @Query(value = "SELECT m.id as id, m.numeroMantenimiento as numeroMantenimiento, m.fechaInicio as fechaInicio, m.fechaEntrega as fechaEntrega, m.idEmpresaEncargada as idEmpresaEncargada, m.idEmpresaSolicitante as idEmpresaSolicitante, m.zona as zona, m.tipoDeMantenimiento as TipoDeMantenimiento FROM schema_bitacorapp.tbi_mantenimientos m" +
            "WHERE m.idEmpresaSolicitante like %?1%", nativeQuery = true)
    ArrayList<MantenimientoDomain> findByIdEmpresaSolicitante(Integer idEmpresaSolicitante);

    @Modifying
    @Query(value = "UPDATE schema_bitacorapp.tbi_mantenimientos SET numero_mantenimiento = ?1, fecha_inicio = ?2, fecha_entrega = ?3, id_empresa_encargada = ?4, id_empresa_solicitante = ?5, zona = ?6 , tipo_de_mantenimiento =?7, modified_date = CURRENT_TIMESTAMP WHERE id = ?8", nativeQuery = true)
    void updateById(Integer numeroMantenimiento, Date fechaInicio, Date fechaEntrega, Integer idEmpresaEncargada, Integer idEmpresaSolicitante, String zona, String tipoDeMantenimiento, long id);

}


