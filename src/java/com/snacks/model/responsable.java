package com.snacks.model;

public class responsable {
    private Integer idResponsables;
    private Integer resIntento;
    private String resNombres;
    private String resApellidos;
    private String resRole;
    private String resUsuario;
    private String resClave;   

    public responsable() {
    }

    public responsable(Integer idResponsables, Integer resIntento, String resNombres, String resApellidos, String resRole, String resUsuario, String resClave) {
        this.idResponsables = idResponsables;
        this.resIntento = resIntento;
        this.resNombres = resNombres;
        this.resApellidos = resApellidos;
        this.resRole = resRole;
        this.resUsuario = resUsuario;
        this.resClave = resClave;
    }

    public responsable(Integer resIntento, String resNombres, String resApellidos, String resRole, String resUsuario, String resClave) {
        this.resIntento = resIntento;
        this.resNombres = resNombres;
        this.resApellidos = resApellidos;
        this.resRole = resRole;
        this.resUsuario = resUsuario;
        this.resClave = resClave;
    }

    public Integer getIdResponsables() {
        return idResponsables;
    }

    public void setIdResponsables(Integer idResponsables) {
        this.idResponsables = idResponsables;
    }

    public Integer getResIntento() {
        return resIntento;
    }

    public void setResIntento(Integer resIntento) {
        this.resIntento = resIntento;
    }

    public String getResNombres() {
        return resNombres;
    }

    public void setResNombres(String resNombres) {
        this.resNombres = resNombres;
    }

    public String getResApellidos() {
        return resApellidos;
    }

    public void setResApellidos(String resApellidos) {
        this.resApellidos = resApellidos;
    }

    public String getResRole() {
        return resRole;
    }

    public void setResRole(String resRole) {
        this.resRole = resRole;
    }

    public String getResUsuario() {
        return resUsuario;
    }

    public void setResUsuario(String resUsuario) {
        this.resUsuario = resUsuario;
    }

    public String getResClave() {
        return resClave;
    }

    public void setResClave(String resClave) {
        this.resClave = resClave;
    }
    
    
     
}
