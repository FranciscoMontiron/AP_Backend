
package com.portfolio.backend.Dto;


public class dtoSkill {
    
    private String nombreS;
    private int porcentaje;
    private String imgS;

    public dtoSkill() {
    }

    public dtoSkill(String nombreS, int porcentaje, String imgS) {
        this.nombreS = nombreS;
        this.porcentaje = porcentaje;
        this.imgS = imgS;
    }

    public String getNombreS() {
        return nombreS;
    }

    public void setNombreS(String nombreS) {
        this.nombreS = nombreS;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getImgS() {
        return imgS;
    }

    public void setImgS(String imgS) {
        this.imgS = imgS;
    }
    
    
    
}
