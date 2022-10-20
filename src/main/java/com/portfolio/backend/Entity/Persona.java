package com.portfolio.backend.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter //es lo mismo que haces los getters y seter de todos los atributos
@Entity
public class Persona {
    
    @Id //las notaciones es para interactuar con la bd ya que sin ellas no las va a reconocer
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    private String nombre;
    
    @NotNull 
    private String apellido;
      
    private String img;
    
    @NotNull
    private String profesion;
    
    @NotNull
    @Lob 
    @Column(name="DESCRIPCION", length=1024)
    private String descripcion;
    
    private String banner;
    
    private String cv;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String img, String profesion, String descripcion, String banner,String cv) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.profesion = profesion;
        this.descripcion = descripcion;
        this.banner = banner;
        this.cv = cv;
    }
    
    
}
