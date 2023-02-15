package com.bitacora.bitacorapp.repository;

import com.bitacora.bitacorapp.domain.PersonasDomain;
import org.springframework.stereotype.Repository;

@Repository
public interface SuscriptorRepository extends JpaRepository<PersonasDomain, Integer> {

    @Query("{'id':?0}")
    public PersonasDomain findByName(Integer id);
}
