
package com.portfolio.backend.Interface;

import com.portfolio.backend.Entity.Skill;
import java.util.List;
import java.util.Optional;


public interface ISkillService {
    public List<Skill> getListSkill();
    
    public Optional<Skill> getSkill(int id);
    
    public Optional<Skill> getByNombreS(String nombreS);
    
    public void saveSkill(Skill skill);
    
    public void deleteSkill(int id);
    
    public boolean existsById(int id);
    
    public boolean existsByNombreS(String nombreS);
}
