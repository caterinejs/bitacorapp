package com.bitacora.bitacorapp.repository;

import com.bitacora.bitacorapp.domain.PersonasDomain;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonasRepository extends JpaRepository<PersonasDomain, String> {

    @Query("{'name':?0}")
    public PersonasDomain findByName(String name);
}
