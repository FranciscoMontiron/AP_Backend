package com.portfolio.backend.Interface;

import com.portfolio.backend.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    //traer una lista de persona
    public List<Persona> getPersona();
    
    //Guardar un objeto de tipo persona
    public void savePersona(Persona persona);
    
    //Eliminar un objeto x ID
    
    public void deletePersona(Long id);
    
    //Buscar persona x ID
    public Persona findPersona(Long id);
}
