
package com.portfolio.backend.Repository;

import com.portfolio.backend.Entity.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IProyectosRepository extends JpaRepository<Proyecto,Integer>{
    public Optional<Proyecto> findByNombreP(String nombreP);
    public boolean existsByNombreP(String nombreP);
   }
