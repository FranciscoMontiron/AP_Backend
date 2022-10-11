package com.portfolio.backend.Interface;

import com.portfolio.backend.Entity.Persona;
import java.util.List;
import java.util.Optional;


public interface IPersonaService {
    public List<Persona> getListPersonas();
    
    public Optional<Persona> getPersona(int id);
    
    public Optional<Persona> getByNombre(String nombre);
    
    public void savePersona(Persona persona);
    
    public void deletePersona(int id);
    
    public boolean existsById(int id);
    
    public boolean existsByNombre(String nombre);
}
