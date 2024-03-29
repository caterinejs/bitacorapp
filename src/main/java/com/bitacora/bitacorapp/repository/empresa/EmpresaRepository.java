package com.bitacora.bitacorapp.repository.empresa;

import com.bitacora.bitacorapp.domain.empresa.EmpresaDomain;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface EmpresaRepository extends CrudRepository<EmpresaDomain, Long> {
    @Query(value = "SELECT e.id as id, e.nombre as nombre, e.telefono as telefono, e.email as email, e.responsable_legal as responsableLegal" +
            " FROM schema_bitacorapp.tbi_empresas e" +
            " WHERE e.nombre like %?1%", nativeQuery = true)
    ArrayList<EmpresaDomain> findByNombre(String nombre);

   @Query(value = "SELECT e.id as id, e.nombre as nombre, e.telefono as telefono," +
           " e.email as email, e.responsableLegal as responsableLegal" +
           "FROM schema_bitacorapp.tbi_empresas e WHERE p.email = ?1", nativeQuery = true)
   EmpresaDomain findByEmail(String email);

   @Query(value = "SELECT count(1) FROM schema_bitacorapp.tbi_empresas e WHERE e.email" +
           " =?1", nativeQuery = true )
    int countByEmail(String email);

    @Modifying
    @Query(value = "UPDATE schema_bitacorapp.tbi_empresas SET nombre = ?1, telefono = ?2, email = ?3, responsable_legal = ?4,  modified_date = CURRENT_TIMESTAMP WHERE id = ?5", nativeQuery = true)
    void updateById(String nombre, String telefono, String email, String responsableLegal, long id);

}
