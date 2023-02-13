package com.bitacora.bitacorapp.domain;



@Document (collection = "personas_data")
public class PersonasDomain {

    @Id
    private String id;
    private String name;
    private Number phone;
    private String signature;
    private String email;
    private Number companyId;
    private String userType;

    public PersonasDomain() {
    }

    public PersonasDomain(String id, String name, Number phone, String signature, String email,
                          Number companyId, String userType) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.signature = signature;
        this.email = email;
        this.companyId = companyId;
        this.userType = userType;
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

    public Number getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Number companyId) {
        this.companyId = companyId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
