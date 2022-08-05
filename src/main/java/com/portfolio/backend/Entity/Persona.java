package com.portfolio.backend.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter //es lo mismo que haces los getters y seter de todos los atributos
@Entity
public class Persona {
    
    @Id //las notaciones es para interactuar con la bd ya que sin ellas no las va a reconocer
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min=1, max=50, message = "no cumple con la logitud") 
    private String nombre;
    
    @NotNull
    @Size(min=1, max=50, message = "no cumple con la logitud") 
    private String apellido;
        
        
    @Size(min=1, max=50, message = "no cumple con la logitud") 
    private String img; // falta resolver aca para las img(ahora esta fija en agunlar)
}
