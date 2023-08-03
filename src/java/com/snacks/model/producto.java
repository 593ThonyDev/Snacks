package com.snacks.model;


public class producto {
    
    private Integer idProducto;
    private String proNombre;
    private String proLote;
    private String proDescripcion;

    public producto() {
    }

    public producto(Integer idProducto, String proNombre, String proLote, String proDescripcion) {
        this.idProducto = idProducto;
        this.proNombre = proNombre;
        this.proLote = proLote;
        this.proDescripcion = proDescripcion;
    }

    public producto(String proNombre, String proLote, String proDescripcion) {
        this.proNombre = proNombre;
        this.proLote = proLote;
        this.proDescripcion = proDescripcion;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getProNombre() {
        return proNombre;
    }

    public void setProNombre(String proNombre) {
        this.proNombre = proNombre;
    }

    public String getProLote() {
        return proLote;
    }

    public void setProLote(String proLote) {
        this.proLote = proLote;
    }

    public String getProDescripcion() {
        return proDescripcion;
    }

    public void setProDescripcion(String proDescripcion) {
        this.proDescripcion = proDescripcion;
    }
    
    
    
}
