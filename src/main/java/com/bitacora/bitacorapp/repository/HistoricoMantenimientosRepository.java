package com.bitacora.bitacorapp.repository;

import com.bitacora.bitacorapp.domain.HistoricoMantenimientosDomain;
import com.bitacora.bitacorapp.domain.PersonasDomain;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoMantenimientosRepository extends JpaRepository<HistoricoMantenimientosDomain, Integer> {

    @Query("{'idHistorical':?0}")
    public HistoricoMantenimientosDomain findByIdHistorical (Integer idHistorical);
}
