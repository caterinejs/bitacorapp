package com.bitacora.bitacorapp.domain;


import jakarta.validation.Valid;

import java.util.ArrayList;

@Document (collection = "empresa_data")
public class EmpresaDomain {

    @Id
    private String id;
    private String name;
    private Number phone;
    private String legallyResponsible;



    public EmpresaDomain() {
    }

    public EmpresaDomain(String id, String name, Number phone, String legallyResponsible) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.legallyResponsible = legallyResponsible;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getPhone() {
        return phone;
    }

    public void setPhone(Number phone) {
        this.phone = phone;
    }

    public String getLegallyResponsible() {
        return legallyResponsible;
    }

    public void setLegallyResponsible(String legallyResponsible) {
        this.legallyResponsible = legallyResponsible;
    }
}
