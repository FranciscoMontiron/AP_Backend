package com.portfolio.backend.Repository;

import com.portfolio.backend.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPersonaRepository extends JpaRepository<Persona,Long> { // el long es por el tipo de dato del id persona
    
}
