package com.bitacora.bitacorapp.repository;

import com.bitacora.bitacorapp.domain.EmpresaDomain;

public interface EmpresaRepository extends ReactiveCrudRepository<EmpresaDomain, String> {

    @Query("{'name':?0}")
    public <EmpresaDomain> findByName(String name);
}
