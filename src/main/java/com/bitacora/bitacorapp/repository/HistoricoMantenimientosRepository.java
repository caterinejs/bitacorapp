package com.bitacora.bitacorapp.repository;

import com.bitacora.bitacorapp.domain.HistoricoMantenimientosDomain;
import com.bitacora.bitacorapp.domain.PersonasDomain;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoMantenimientosRepository //extends CrudRepository<HistoricoMantenimientosDomain, Integer>
{

   // @Query("{'idHistorical':?0}")
   // public HistoricoMantenimientosDomain findByIdHistorical (Integer idHistorical);
}
