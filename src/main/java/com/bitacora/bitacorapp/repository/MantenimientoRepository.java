package com.bitacora.bitacorapp.repository;

import com.bitacora.bitacorapp.domain.EmpresaDomain;
import com.bitacora.bitacorapp.domain.MantenimientoDomain;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MantenimientoRepository //extends CrudRepository<MantenimientoDomain, String>
{

    //@Query("{'zone':?0}")
    //public MantenimientoDomain findByZone(String zone);
}
