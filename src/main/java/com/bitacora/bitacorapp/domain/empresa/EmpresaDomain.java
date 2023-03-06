package com.bitacora.bitacorapp.domain.empresa;

import jakarta.validation.Valid;
import java.util.ArrayList;


public class EmpresaDomain {

    private Integer id;
    private String name;
    private String phone;
    private String legallyResponsible;

    public EmpresaDomain() {
    }

    public EmpresaDomain(Integer id, String name, String phone, String legallyResponsible) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.legallyResponsible = legallyResponsible;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLegallyResponsible() {
        return legallyResponsible;
    }

    public void setLegallyResponsible(String legallyResponsible) {
        this.legallyResponsible = legallyResponsible;
    }
}
