package com.bitacora.bitacorapp.repository.suscriptor;

import com.bitacora.bitacorapp.domain.suscriptor.SuscriptorDomain;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface SuscriptorRepository extends CrudRepository<SuscriptorDomain, Long> {

  @Query(value = "SELECT s.id as id, s.nombreUsuario as nombreUsuario, s.telefono as telefono, " +
          "s.tipoUsuario as tipoUsuario , s.tipoSuscriptor as tipoSuscriptor, s.email as email, " +
          "p.user_type as user_type FROM schema_bitacorapp.tbi_suscriptores s " +
          "WHERE s.nombreUsuario like %?1%", nativeQuery = true)
  ArrayList<SuscriptorDomain> findByNombreUsuario(String nombreUsuario);

  @Query(value = "SELECT s.id as id, s.nombreUsuario as nombreUsuario, s.telefono as telefono," +
          " s.tipoUsuario as tipoUsuario , s.email as email, s.tipoSuscriptor as tipoSuscriptor," +
          " s.user_type as user_type FROM schema_bitacorapp.tbi_suscriptores s WHERE s.email = ?1", nativeQuery = true)
  SuscriptorDomain findByEmail(String email);

  @Query(value = "SELECT count(1) FROM schema_bitacorapp.tbi_suscriptores s WHERE s.email = ?1", nativeQuery = true)
  int countByEmail(String email);

  @Modifying
  @Query(value = "UPDATE schema_bitacorapp.tbi_suscriptores SET email = ?1,  nombre_usuario = ?2, telefono = ?3, tipo_usuario= ?4, tipo_suscriptor = ?5, modified_date = CURRENT_TIMESTAMP WHERE id = ?6", nativeQuery = true)
  void updateById(String email, String nombreUsuario, String Telefono, String tipoUsuario, String tipoSuscriptor,  long id);


}
