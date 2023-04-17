package com.bitacora.bitacorapp.domain.historicomantenimiento;

import com.bitacora.bitacorapp.domain.audit.AuditDomain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name ="tbi_historicos")
@Getter
@Setter
public class HistoricoMantenimientosDomain extends AuditDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)

    private Long id;
    @Column(name = "idHistoria")
    private Integer idHistoria;
    @Column(name = "detalleMantenimiento")
    private String detalleMantenimiento;
    @Column(name = "fechaEntrega")
    private Date fechaEntrega;
    @Column(name = "fechaRecibido")
    private Date fechaRecibido;
    @Column(name = "idResponsable")
    private Integer idResponsable;
    @Column(name = "idAutoriza")
    private Integer idAutoriza;

    @Column(name = "idElabora")
    private Integer idElabora;

    public HistoricoMantenimientosDomain() {
    }

    public HistoricoMantenimientosDomain(Long id, Integer idHistoria, String detalleMantenimiento, Date fechaEntrega, Date fechaRecibido, Integer idResponsable, Integer idAutoriza, Integer idElabora) {
        this.id = id;
        this.idHistoria = idHistoria;
        this.detalleMantenimiento = detalleMantenimiento;
        this.fechaEntrega = fechaEntrega;
        this.fechaRecibido = fechaRecibido;
        this.idResponsable = idResponsable;
        this.idAutoriza = idAutoriza;
        this.idElabora = idElabora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(Integer idHistoria) {
        this.idHistoria = idHistoria;
    }

    public String getDetalleMantenimiento() {
        return detalleMantenimiento;
    }

    public void setDetalleMantenimiento(String detalleMantenimiento) {
        this.detalleMantenimiento = detalleMantenimiento;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Date getFechaRecibido() {
        return fechaRecibido;
    }

    public void setFechaRecibido(Date fechaRecibido) {
        this.fechaRecibido = fechaRecibido;
    }

    public Integer getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(Integer idResponsable) {
        this.idResponsable = idResponsable;
    }

    public Integer getIdAutoriza() {
        return idAutoriza;
    }

    public void setIdAutoriza(Integer idAutoriza) {
        this.idAutoriza = idAutoriza;
    }

    public Integer getIdElabora() {
        return idElabora;
    }

    public void setIdElabora(Integer idElabora) {
        this.idElabora = idElabora;
    }
}
