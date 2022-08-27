
package com.portfolio.backend.Interface;

import com.portfolio.backend.Entity.Proyecto;
import java.util.List;
import java.util.Optional;


public interface IProyectosService {
    public List<Proyecto> getListProyectos();
    
    public Optional<Proyecto> getProyecto(int id);
    
    public Optional<Proyecto> getByNombreP(String tituloProyect);
    
    public void saveProyecto(Proyecto skill);
    
    public void deleteProyecto(int id);
    
    public boolean existsById(int id);
    
    public boolean existsByNombreP(String tituloProyect);
}
