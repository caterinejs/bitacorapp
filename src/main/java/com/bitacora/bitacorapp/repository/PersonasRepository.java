package com.bitacora.bitacorapp.repository;

import com.bitacora.bitacorapp.domain.PersonasDomain;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface PersonasRepository extends CrudRepository<PersonasDomain, Long> {

    @Query(value = "SELECT p.id as id, p.name as name, p.phone as phone, p.signature as signature , p.email as email, p.company_id as company_id, p.user_type as user_type FROM schema_bitacorapp.tbi_personas p WHERE p.name like %?1%", nativeQuery = true)
    ArrayList<PersonasDomain> findByName(String name);

    @Query(value = "SELECT p.id as id, p.name as name, p.phone as phone, p.signature as signature , p.email as email, p.company_id as company_id, p.user_type as user_type FROM schema_bitacorapp.tbi_personas p WHERE p.email = ?1", nativeQuery = true)
    PersonasDomain findByEmail(String email);

    @Query(value = "SELECT count(1) FROM schema_bitacorapp.tbi_personas p WHERE p.email = ?1", nativeQuery = true)
    int countByEmail(String email);

    /*Modifier UPDATE
    @Modifying
    @Query(value = "UPDATE product SET description = ?1, category = ?2, price = ?3 WHERE id = ?4", nativeQuery = true)
    void updateById(String description, String category, BigDecimal price, long id);
     */
}
