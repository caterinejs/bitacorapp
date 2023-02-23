package com.bitacora.bitacorapp.repository;

import com.bitacora.bitacorapp.domain.PersonasDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuscriptorRepository //extends CrudRepository<PersonasDomain, Integer>
 {

   // @Query("{'id':?0}")
    //public PersonasDomain findByName(Integer id);
}
