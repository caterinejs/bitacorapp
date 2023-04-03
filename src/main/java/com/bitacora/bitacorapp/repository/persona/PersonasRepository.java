package com.bitacora.bitacorapp.repository.persona;

import com.bitacora.bitacorapp.domain.persona.PersonasDomain;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface PersonasRepository extends CrudRepository<PersonasDomain, Long> {

    @Query(value = "SELECT p.id as id, p.name as name, p.phone as phone, " +
            "p.signature as signature , p.email as email, p.company_id as company_id, " +
            "p.user_type as user_type FROM schema_bitacorapp.tbi_personas p " +
            "WHERE p.name like %?1%", nativeQuery = true)
    ArrayList<PersonasDomain> findByName(String name);

    @Query(value = "SELECT p.id as id, p.name as name, p.phone as phone," +
            " p.signature as signature , p.email as email, p.company_id as company_id," +
            " p.user_type as user_type FROM schema_bitacorapp.tbi_personas p WHERE p.email = ?1", nativeQuery = true)
    PersonasDomain findByEmail(String email);

    @Query(value = "SELECT count(1) FROM schema_bitacorapp.tbi_personas p WHERE p.email = ?1", nativeQuery = true)
    int countByEmail(String email);

    @Modifying
    @Query(value = "UPDATE schema_bitacorapp.tbi_personas SET name = ?1, email = ?2, company_id = ?3, phone = ?4, signature = ?5, user_type = ?6 , modified_date = CURRENT_TIMESTAMP WHERE id = ?7", nativeQuery = true)
    void updateById(String name, String email, Integer companyId, String phone, String signature, String userType, long id);

}
