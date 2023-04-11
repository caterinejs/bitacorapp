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
    @Column(name = "name")
    private String name;
    @Column(name ="phone")
    private String phone;
    @Column(name ="email")
    private String email;
    @Column(name ="legallyResponsible")
    private String legallyResponsible;

    public EmpresaDomain() {
    }

    public EmpresaDomain(Long id, String name, String phone, String email, String legallyResponsible) {

    this.id = id;
    this.name = name;
    this.phone = phone;
    this.email = email;
    this.legallyResponsible = legallyResponsible;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLegallyResponsible() {
        return legallyResponsible;
    }

    public void setLegallyResponsible(String legallyResponsible) {
        this.legallyResponsible = legallyResponsible;
    }
}

