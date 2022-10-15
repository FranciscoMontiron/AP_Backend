
package com.portfolio.backend.Dto;

import java.util.Calendar;


public class DtoProyectos {
    
    private String nombreP;
    private String descripcionP;
    private String urlP;
    private String imgP;
    private Calendar fecha;

    public DtoProyectos() {
    }

    public DtoProyectos(String nombreP, String descripcionP, String urlP, String imgP,Calendar fecha) {
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.urlP = urlP;
        this.imgP = imgP;
        this.fecha = fecha;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public String getUrlP() {
        return urlP;
    }

    public void setUrlP(String urlP) {
        this.urlP = urlP;
    }

    public String getImgP() {
        return imgP;
    }

    public void setImgP(String imgP) {
        this.imgP = imgP;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }
    
    
    
}
