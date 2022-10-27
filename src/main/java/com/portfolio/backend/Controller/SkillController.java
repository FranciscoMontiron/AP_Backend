
package com.portfolio.backend.Controller;

import com.portfolio.backend.Dto.dtoSkill;
import com.portfolio.backend.Entity.Skill;
import com.portfolio.backend.Security.Controller.Mensaje;
import com.portfolio.backend.Service.SkillService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/skill")
@CrossOrigin(origins = "https://apportfolio-c34c4.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class SkillController {
    @Autowired 
    private SkillService skillServ;
    
    @GetMapping("/list")
    public ResponseEntity<List<Skill>> listSkills(){
        List<Skill> listSkills = skillServ.getListSkill();
        return new ResponseEntity(listSkills,HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkill dtoSkill){
        if(StringUtils.isBlank(dtoSkill.getNombreS())){
            return new ResponseEntity(new Mensaje("El nombre de la Skill es OBLIGATORIA"),HttpStatus.BAD_REQUEST);
        }
        if(skillServ.existsByNombreS(dtoSkill.getNombreS())){
            return new ResponseEntity(new Mensaje("Ese nombre de la Skill ya existe"),HttpStatus.BAD_REQUEST);
        }
        Skill skill = new Skill(dtoSkill.getNombreS(),dtoSkill.getPorcentaje(), dtoSkill.getImgS());
        skillServ.saveSkill(skill);
        
        return new ResponseEntity(new Mensaje("Skill creada con exito"),HttpStatus.OK);
    }
    
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id,@RequestBody dtoSkill dtoSkill){
        if(!skillServ.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"),HttpStatus.BAD_REQUEST);
        }
        if(skillServ.existsByNombreS(dtoSkill.getNombreS()) && skillServ.getByNombreS(dtoSkill.getNombreS()).get().getId()!= id){
            return new ResponseEntity(new Mensaje("Esa Skill ya existe"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoSkill.getNombreS())){
            return new ResponseEntity(new Mensaje("El nombre es OBLIGATORIO"),HttpStatus.BAD_REQUEST);
        }
        
        Skill skill = skillServ.getSkill(id).get();
        skill.setNombreS(dtoSkill.getNombreS());
        skill.setPorcentaje(dtoSkill.getPorcentaje());
        skill.setImgS(dtoSkill.getImgS());
        
        skillServ.saveSkill(skill);
        
        return new ResponseEntity(new Mensaje("Proyecto editado correctamente"),HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!skillServ.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"),HttpStatus.BAD_REQUEST);
        }
        skillServ.deleteSkill(id);
        
        return new ResponseEntity(new Mensaje("Skill eliminada correctamente"),HttpStatus.OK);
    }
    
    @GetMapping("/getSkill/{id}")
    public ResponseEntity<Skill> getById(@PathVariable("id") int id){
        if(!skillServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Skill skill = skillServ.getSkill(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }
}
