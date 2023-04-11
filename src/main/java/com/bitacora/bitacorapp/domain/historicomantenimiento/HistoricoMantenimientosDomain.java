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
    @Column(name = "idHistorical")
    private Integer idHistorical;
    @Column(name = "maintenanceDetail")
    private String maintenanceDetail;
    @Column(name = "deliverDate")
    private Date deliverDate;
    @Column(name = "dateReceived")
    private Date dateReceived;
    @Column(name = "idResponsible")
    private Integer idResponsible;
    @Column(name = "idAuthorizes")
    private Integer idAuthorizes;

    public HistoricoMantenimientosDomain() {
    }

    public HistoricoMantenimientosDomain(Long id, Integer idHistorical, String maintenanceDetail,
                                         Date deliverDate, Date dateReceived, Integer idResponsible,
                                         Integer idAuthorizes) {
        this.id = id;
        this.idHistorical = idHistorical;
        this.maintenanceDetail = maintenanceDetail;
        this.deliverDate = deliverDate;
        this.dateReceived = dateReceived;
        this.idResponsible = idResponsible;
        this.idAuthorizes = idAuthorizes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdHistorical() {
        return idHistorical;
    }

    public void setIdHistorical(Integer idHistorical) {
        this.idHistorical = idHistorical;
    }

    public String getMaintenanceDetail() {
        return maintenanceDetail;
    }

    public void setMaintenanceDetail(String maintenanceDetail) {
        this.maintenanceDetail = maintenanceDetail;
    }

    public Date getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(Date deliverDate) {
        this.deliverDate = deliverDate;
    }

    public Date getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(Date dateReceived) {
        this.dateReceived = dateReceived;
    }

    public Integer getIdResponsible() {
        return idResponsible;
    }

    public void setIdResponsible(Integer idResponsible) {
        this.idResponsible = idResponsible;
    }

    public Integer getIdAuthorizes() {
        return idAuthorizes;
    }

    public void setIdAuthorizes(Integer idAuthorizes) {
        this.idAuthorizes = idAuthorizes;
    }
}
