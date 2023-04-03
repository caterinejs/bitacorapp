package com.bitacora.bitacorapp.domain.empresa;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table( name = "tbi_empresas")
@Getter
@Setter

public class EmpresaDomain extends a{

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
