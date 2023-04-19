package com.bitacora.bitacorapp.domain.suscriptor;


import com.bitacora.bitacorapp.domain.audit.AuditDomain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbi_suscriptores")
@Getter
@Setter
public class SuscriptorDomain extends AuditDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name="id", nullable = false)
    private Long id;

    @Column(name = "email")
    private String email;
    @Column(name = "nombreUsuario")
    private String nombreUsuario;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "tipoUsuario")
    private String tipoUsuario;
    @Column(name = "tipoSuscriptor")
    private String tipoSuscriptor;

    public SuscriptorDomain() {
    }

    public SuscriptorDomain(Long id, String email, String nombreUsuario, String telefono, String tipoUsuario, String tipoSuscriptor) {
        this.id = id;
        this.email = email;
        this.nombreUsuario = nombreUsuario;
        this.telefono = telefono;
        this.tipoUsuario = tipoUsuario;
        this.tipoSuscriptor = tipoSuscriptor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getTipoSuscriptor() {
        return tipoSuscriptor;
    }

    public void setTipoSuscriptor(String tipoSuscriptor) {
        this.tipoSuscriptor = tipoSuscriptor;
    }
}



