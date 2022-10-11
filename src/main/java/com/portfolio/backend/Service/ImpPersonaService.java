package com.portfolio.backend.Service;

import com.portfolio.backend.Entity.Persona;
import com.portfolio.backend.Interface.IPersonaService;
import com.portfolio.backend.Repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ImpPersonaService implements IPersonaService {
    
    @Autowired IPersonaRepository ipersonaRepository;

    @Override
    public List<Persona> getListPersonas() {
        return ipersonaRepository.findAll();
    }

    @Override
    public Optional<Persona> getPersona(int id) {
        return ipersonaRepository.findById(id);
    }

    @Override
    public Optional<Persona> getByNombre(String nombre) {
        return ipersonaRepository.findByNombre(nombre);
    }

    @Override
    public void savePersona(Persona persona) {
        ipersonaRepository.save(persona);
    }

    @Override
    public void deletePersona(int id) {
       ipersonaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(int id) {
        return ipersonaRepository.existsById(id);
    }

    @Override
    public boolean existsByNombre(String nombre) {
       return ipersonaRepository.existsByNombre(nombre);
    }


}
