package com.snacks.model;

public class responsables {
    private Integer idResponsables;
    private String resNombres;
    private String resApellidos;
    private String resRole;
    private String resUsuario;
    private String resClave;   

    public responsables() {
    }
    
    public responsables(Integer idResponsables, String resNombres, String resApellidos, String resRole, String resUsuario, String resClave) {
        this.idResponsables = idResponsables;
        this.resNombres = resNombres;
        this.resApellidos = resApellidos;
        this.resRole = resRole;
        this.resUsuario = resUsuario;
        this.resClave = resClave;
    }
    
      public responsables(String resNombres, String resApellidos, String resRole, String resUsuario, String resClave) {
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
