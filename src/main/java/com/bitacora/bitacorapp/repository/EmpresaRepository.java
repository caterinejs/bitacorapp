package com.bitacora.bitacorapp.repository;

import com.bitacora.bitacorapp.domain.EmpresaDomain;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EmpresaRepository //extends CrudRepository<EmpresaDomain, String>
{

    //@Query("{'name':?0}")
    //public EmpresaDomain findByName(String name);
}
