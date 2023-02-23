package com.bitacora.bitacorapp.domain;


public class SuscriptorDomain {


    private Integer id;
    private String email;
    private String phone;
    private String tipoUsuario;
    private String tiposuscriptor;

    public SuscriptorDomain() {
    }

    public SuscriptorDomain(Integer id, String email, String phone, String tipoUsuario, String tiposuscriptor) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.tipoUsuario = tipoUsuario;
        this.tiposuscriptor = tiposuscriptor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getTiposuscriptor() {
        return tiposuscriptor;
    }

    public void setTiposuscriptor(String tiposuscriptor) {
        this.tiposuscriptor = tiposuscriptor;
    }
}
