package com.bitacora.bitacorapp.domain.mantenimiento;

import com.bitacora.bitacorapp.domain.audit.AuditDomain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Entity
@Table(name = "tbi_mantenimientos")
@Getter
@Setter

public class MantenimientoDomain extends AuditDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "numeroMantenimiento")
    private Integer numeroMantenimiento;
    @Column(name = "fechaInicio")
    private Date fechaInicio;
    @Column(name = "FechaEntrega")
    private Date FechaEntrega;
    @Column(name = "idEmpresaEncargada")
    private Integer idEmpresaEncargada;
    @Column(name = "idEmpresaSolicitant")
    private Integer idEmpresaSolicitante;
    @Column(name = "zona")
    private String zona;
    @Column(name = "tipoDeMantenimiento")
    private String tipoDeMantenimiento;

    public MantenimientoDomain() {
    }

    public MantenimientoDomain(Long id, Integer numeroMantenimiento, Date fechaInicio, Date fechaEntrega, Integer idEmpresaEncargada,
                               Integer idEmpresaSolicitante, String zona, String tipoDeMantenimiento) {
        this.id = id;
        this.numeroMantenimiento = numeroMantenimiento;
        this.fechaInicio = fechaInicio;
        FechaEntrega = fechaEntrega;
        this.idEmpresaEncargada = idEmpresaEncargada;
        this.idEmpresaSolicitante = idEmpresaSolicitante;
        this.zona = zona;
        this.tipoDeMantenimiento = tipoDeMantenimiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumeroMantenimiento() {
        return numeroMantenimiento;
    }

    public void setNumeroMantenimiento(Integer numeroMantenimiento) {
        this.numeroMantenimiento = numeroMantenimiento;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaEntrega() {
        return FechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        FechaEntrega = fechaEntrega;
    }

    public Integer getIdEmpresaEncargada() {
        return idEmpresaEncargada;
    }

    public void setIdEmpresaEncargada(Integer idEmpresaEncargada) {
        this.idEmpresaEncargada = idEmpresaEncargada;
    }

    public Integer getIdEmpresaSolicitante() {
        return idEmpresaSolicitante;
    }

    public void setIdEmpresaSolicitante(Integer idEmpresaSolicitante) {
        this.idEmpresaSolicitante = idEmpresaSolicitante;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getTipoDeMantenimiento() {
        return tipoDeMantenimiento;
    }

    public void setTipoDeMantenimiento(String tipoDeMantenimiento) {
        this.tipoDeMantenimiento = tipoDeMantenimiento;
    }
}
