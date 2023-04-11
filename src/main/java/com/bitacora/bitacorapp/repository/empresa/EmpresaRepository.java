package com.bitacora.bitacorapp.repository.empresa;

import com.bitacora.bitacorapp.domain.empresa.EmpresaDomain;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface EmpresaRepository extends CrudRepository<EmpresaDomain, Long> {
    @Query(value = "SELECT P.id as id, p.name as name, p.phone as phone, p.email as email, p.legallyResponsible, " +
            " FROM schema_bitacorapp.tbi_empresas p " +
            "WHERE p.name like %?1%", nativeQuery = true)
    ArrayList<EmpresaDomain> findByName(String name);

   @Query(value = "SELECT p.id as id, p.name as name, p.phone as phone," +
           " p.email as email, p.legallyResponsible as legallyResponsible " +
           "FROM schema_bitacorapp.tbi_personas p WHERE p.email = ?1", nativeQuery = true)
   EmpresaDomain findByEmail(String email);

   @Query(value = "SELECT count(1) FROM schema_bitacorapp.tbi_empresas p WHERE p.name =?1", nativeQuery = true )
    int countByEmail(String email);

    @Modifying
    @Query(value ="UPDATE schema_bitacorapp.tbi_empresas SET name =?1, phone =?2," +
            " legally_Responsible =?3, modified_date = CURRENT_TIMESTAMP WHERE id =?4," +
            " nativeQuery = true")
    void updateById(String name, String phone, String legallyResponsible, String responsible, Long id);



}
