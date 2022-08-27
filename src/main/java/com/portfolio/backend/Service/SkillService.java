
package com.portfolio.backend.Service;

import com.portfolio.backend.Entity.Skill;
import com.portfolio.backend.Interface.ISkillService;
import com.portfolio.backend.Repository.ISkillRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SkillService implements ISkillService {
    
    @Autowired
    ISkillRepository iSkillRepository;

    @Override
    public List<Skill> getListSkill() {
        return iSkillRepository.findAll();
    }

    @Override
    public Optional<Skill> getSkill(int id) {
        return iSkillRepository.findById(id);
    }

    @Override
    public Optional<Skill> getByNombreS(String nombreS) {
        return iSkillRepository.findByNombreS(nombreS);
    }

    @Override
    public void saveSkill(Skill skill) {
        iSkillRepository.save(skill);
    }

    @Override
    public void deleteSkill(int id) {
        iSkillRepository.deleteById(id);
    }

    @Override
    public boolean existsById(int id) {
        return iSkillRepository.existsById(id);
    }

    @Override
    public boolean existsByNombreS(String nombreS) {
        return iSkillRepository.existsByNombreS(nombreS);
    }
    
}
