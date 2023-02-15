package com.bitacora.bitacorapp.repository;

import com.bitacora.bitacorapp.domain.PersonasDomain;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonasRepository extends CrudRepository<PersonasDomain, String> {

    @Query("SELECT p FROM Person u WHERE u.name = ?1")
    public PersonasDomain findByName(String name);
}
