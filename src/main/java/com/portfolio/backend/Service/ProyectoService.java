
package com.portfolio.backend.Service;

import com.portfolio.backend.Entity.Proyecto;
import com.portfolio.backend.Interface.IProyectosService;
import com.portfolio.backend.Repository.IProyectosRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectoService implements IProyectosService {
    
    @Autowired
    private IProyectosRepository iProyectRepo;

    @Override
    public List<Proyecto> getListProyectos() {
        return iProyectRepo.findAll();
    }

    @Override
    public Optional<Proyecto> getProyecto(int id) {
        return iProyectRepo.findById(id);
    }

    @Override
    public Optional<Proyecto> getByNombreP(String nombreP) {
        return iProyectRepo.findByNombreP(nombreP);
    }

    @Override
    public void saveProyecto(Proyecto proyecto) {
        iProyectRepo.save(proyecto);
    }

    @Override
    public void deleteProyecto(int id) {
        iProyectRepo.deleteById(id);
    }

    @Override
    public boolean existsById(int id) {
        return iProyectRepo.existsById(id);
    }

    @Override
    public boolean existsByNombreP(String tituloProyect) {
        return iProyectRepo.existsByNombreP(tituloProyect);
    }
    
}
