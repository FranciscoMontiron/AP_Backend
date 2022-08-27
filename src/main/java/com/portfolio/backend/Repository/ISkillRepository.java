
package com.portfolio.backend.Repository;

import com.portfolio.backend.Entity.Skill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ISkillRepository extends JpaRepository<Skill,Integer>{
    public Optional<Skill> findByNombreS(String nombreS);
    public boolean existsByNombreS(String nombreS);
   }
