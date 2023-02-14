package com.bitacora.bitacorapp.domain;

import java.util.Date;

@Document (collection = "historicoMantenimientos_data")
public class HistoricoMantenimientosDomain {

    @Id
    private Integer idHistorical;
    private String maintenanceDetail;
    private Date deliverDate;
    private Date dateReceived;
    private Integer idResponsible;
    private Integer idAuthorizes;

    public HistoricoMantenimientosDomain() {
    }

    public HistoricoMantenimientosDomain(Integer idHistorical, String maintenanceDetail,
                                         Date deliverDate, Date dateReceived, Integer idResponsible,
                                         Integer idAuthorizes) {
        this.idHistorical = idHistorical;
        this.maintenanceDetail = maintenanceDetail;
        this.deliverDate = deliverDate;
        this.dateReceived = dateReceived;
        this.idResponsible = idResponsible;
        this.idAuthorizes = idAuthorizes;
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
