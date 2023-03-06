package com.bitacora.bitacorapp.domain.persona;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbi_personas")
@Getter
@Setter
public class PersonasDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "signature")
    private String signature;
    @Column(name = "email")
    private String email;
    @Column(name = "company_id")
    private Integer companyId;
    @Column(name = "user_type")
    private String userType;

    public PersonasDomain() {
    }

    public PersonasDomain(Long id, String name, String phone, String signature,
                          String email, Integer companyId, String userType) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.signature = signature;
        this.email = email;
        this.companyId = companyId;
        this.userType = userType;
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

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
