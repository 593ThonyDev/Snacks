package com.snacks.model;

public class registro {
   
    private Integer idRegistro;
    private String regCodigo;
    private String regVigencia;
    private String regVersion;
    private String regFecha;
    private String regInicio;
    private String regFin;
    private String regLinea;
    private String regResponsable;
    private String regPersonas;
    private String regAceite;

    public registro() {
    }

    public registro(Integer idRegistro, String regCodigo, String regVigencia, String regVersion, String regFecha, String regInicio, String regFin, String regLinea, String regResponsable, String regPersonas, String regAceite) {
        this.idRegistro = idRegistro;
        this.regCodigo = regCodigo;
        this.regVigencia = regVigencia;
        this.regVersion = regVersion;
        this.regFecha = regFecha;
        this.regInicio = regInicio;
        this.regFin = regFin;
        this.regLinea = regLinea;
        this.regResponsable = regResponsable;
        this.regPersonas = regPersonas;
        this.regAceite = regAceite;
    }

    public registro(String regCodigo, String regVigencia, String regVersion, String regFecha, String regInicio, String regFin, String regLinea, String regResponsable, String regPersonas, String regAceite) {
        this.regCodigo = regCodigo;
        this.regVigencia = regVigencia;
        this.regVersion = regVersion;
        this.regFecha = regFecha;
        this.regInicio = regInicio;
        this.regFin = regFin;
        this.regLinea = regLinea;
        this.regResponsable = regResponsable;
        this.regPersonas = regPersonas;
        this.regAceite = regAceite;
    }

    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public String getRegCodigo() {
        return regCodigo;
    }

    public void setRegCodigo(String regCodigo) {
        this.regCodigo = regCodigo;
    }

    public String getRegVigencia() {
        return regVigencia;
    }

    public void setRegVigencia(String regVigencia) {
        this.regVigencia = regVigencia;
    }

    public String getRegVersion() {
        return regVersion;
    }

    public void setRegVersion(String regVersion) {
        this.regVersion = regVersion;
    }

    public String getRegFecha() {
        return regFecha;
    }

    public void setRegFecha(String regFecha) {
        this.regFecha = regFecha;
    }

    public String getRegInicio() {
        return regInicio;
    }

    public void setRegInicio(String regInicio) {
        this.regInicio = regInicio;
    }

    public String getRegFin() {
        return regFin;
    }

    public void setRegFin(String regFin) {
        this.regFin = regFin;
    }

    public String getRegLinea() {
        return regLinea;
    }

    public void setRegLinea(String regLinea) {
        this.regLinea = regLinea;
    }

    public String getRegResponsable() {
        return regResponsable;
    }

    public void setRegResponsable(String regResponsable) {
        this.regResponsable = regResponsable;
    }

    public String getRegPersonas() {
        return regPersonas;
    }

    public void setRegPersonas(String regPersonas) {
        this.regPersonas = regPersonas;
    }

    public String getRegAceite() {
        return regAceite;
    }

    public void setRegAceite(String regAceite) {
        this.regAceite = regAceite;
    }
    
    
    
}
