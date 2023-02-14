package com.bitacora.bitacorapp.domain;



@Document (collection = "personas_data")
public class PersonasDomain {

    @Id
    private Integer id;
    private String name;
    private String phone;
    private String signature;
    private String email;
    private Integer companyId;
    private String userType;

    public PersonasDomain() {
    }

    public PersonasDomain(Integer id, String name, String phone, String signature,
                          String email, Integer companyId, String userType) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.signature = signature;
        this.email = email;
        this.companyId = companyId;
        this.userType = userType;
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
