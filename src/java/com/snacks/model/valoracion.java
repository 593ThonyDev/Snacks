package com.snacks.model;


public class valoracion {
    
   private Integer idValoracion;
   private String valTipo;
   private String valValor;

    public valoracion() {
    }

    public valoracion(Integer idValoracion, String valTipo, String valValor) {
        this.idValoracion = idValoracion;
        this.valTipo = valTipo;
        this.valValor = valValor;
    }

    public valoracion(String valTipo, String valValor) {
        this.valTipo = valTipo;
        this.valValor = valValor;
    }

    public Integer getIdValoracion() {
        return idValoracion;
    }

    public void setIdValoracion(Integer idValoracion) {
        this.idValoracion = idValoracion;
    }

    public String getValTipo() {
        return valTipo;
    }

    public void setValTipo(String valTipo) {
        this.valTipo = valTipo;
    }

    public String getValValor() {
        return valValor;
    }

    public void setValValor(String valValor) {
        this.valValor = valValor;
    }
   
   
   
}
