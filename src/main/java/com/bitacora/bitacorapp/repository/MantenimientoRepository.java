package com.bitacora.bitacorapp.repository;

import com.bitacora.bitacorapp.domain.EmpresaDomain;
import com.bitacora.bitacorapp.domain.MantenimientoDomain;

public interface MantenimientoRepository extends ReactiveCrudRepository<MantenimientoDomain, String> {

    @Query("{'zone':?0}")
    public <MantenimientoDomain> findByZone(String zone);
}
