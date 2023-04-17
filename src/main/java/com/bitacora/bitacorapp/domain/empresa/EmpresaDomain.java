package com.bitacora.bitacorapp.domain.empresa;

import com.bitacora.bitacorapp.domain.audit.AuditDomain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table( name = "tbi_empresas")
@Getter
@Setter

public class EmpresaDomain extends AuditDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)

    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "email")
    private String email;
    @Column(name = "responsableLegal")
    private String responsableLegal;

    public EmpresaDomain() {
    }

    public EmpresaDomain(Long id, String nombre, String telefono, String email, String responsableLegal) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.responsableLegal = responsableLegal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResponsableLegal() {
        return responsableLegal;
    }

    public void setResponsableLegal(String responsableLegal) {
        this.responsableLegal = responsableLegal;
    }
}