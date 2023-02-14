package com.bitacora.bitacorapp.domain;

import java.util.Date;

@Document (collection = "mantenimiento_data")
public class MantenimientoDomain {

    @Id
    private Integer id;
    private Date startDate;
    private Date deliverDate;
    private Integer idCommissionedCompany;
    private Integer idRequestingCompany;
    private String zone;
    private String typeOfMaintenance;

    public MantenimientoDomain() {
    }

    public MantenimientoDomain(Integer id, Date startDate, Date deliverDate, Integer idCommissionedCompany,
                               Integer idRequestingCompany, String zone, String typeOfMaintenance) {
        this.id = id;
        this.startDate = startDate;
        this.deliverDate = deliverDate;
        this.idCommissionedCompany = idCommissionedCompany;
        this.idRequestingCompany = idRequestingCompany;
        this.zone = zone;
        this.typeOfMaintenance = typeOfMaintenance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(Date deliverDate) {
        this.deliverDate = deliverDate;
    }

    public Integer getIdCommissionedCompany() {
        return idCommissionedCompany;
    }

    public void setIdCommissionedCompany(Integer idCommissionedCompany) {
        this.idCommissionedCompany = idCommissionedCompany;
    }

    public Integer getIdRequestingCompany() {
        return idRequestingCompany;
    }

    public void setIdRequestingCompany(Integer idRequestingCompany) {
        this.idRequestingCompany = idRequestingCompany;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getTypeOfMaintenance() {
        return typeOfMaintenance;
    }

    public void setTypeOfMaintenance(String typeOfMaintenance) {
        this.typeOfMaintenance = typeOfMaintenance;
    }
}
