package com.portfolio.backend.Controller;

import com.portfolio.backend.Dto.dtoPersona;
import com.portfolio.backend.Entity.Persona;
import com.portfolio.backend.Interface.IPersonaService;
import com.portfolio.backend.Security.Controller.Mensaje;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = "https://apportfolio-c34c4.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
    
    @GetMapping("/list")
    public ResponseEntity<List<Persona>> listaPersonas(){
        List<Persona> listaPersonas = ipersonaService.getListPersonas();
        return new ResponseEntity(listaPersonas,HttpStatus.OK);
    }
    
    
    /*
    @GetMapping("/traer") //trae de la bd al front 
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }*/
    
   @PreAuthorize("hasRole('ADMIN')")
   @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPersona dtoPersona){
        if(StringUtils.isBlank(dtoPersona.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es OBLIGATORIO"),HttpStatus.BAD_REQUEST);
        }
        if(ipersonaService.existsByNombre(dtoPersona.getNombre())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"),HttpStatus.BAD_REQUEST);
        }
        Persona persona = new Persona(dtoPersona.getNombre(),dtoPersona.getApellido(),dtoPersona.getImg(),
                dtoPersona.getProfesion(),dtoPersona.getDescripcion(),dtoPersona.getBanner(),dtoPersona.getCv());
        ipersonaService.savePersona(persona);
        
        return new ResponseEntity(new Mensaje("Persona creada con exito"),HttpStatus.OK);
    }
    /*
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear") //desde front guarde en la bd
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "la persona se creo correctamente";
    }*/
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!ipersonaService.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"),HttpStatus.BAD_REQUEST);
        }
        ipersonaService.deletePersona(id);
        
        return new ResponseEntity(new Mensaje("Persona eliminada correctamente"),HttpStatus.OK);
    }
    /*
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }*/
    
    // URL:PUERTO/personas/editar/4/nombre & apellido & img
    /*
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("apellido") String nuevoApellido,
            @RequestParam("img") String nuevoImg,
            @RequestParam("profesion") String nuevaProfesion,
            @RequestParam("descripcion") String nuevaDescripcion){
            ){
        Persona persona = ipersonaService.findPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);
        persona.setProfesion(nuevaProfesion);
        persona.setDescripcion(nuevaDescripcion);
                
        
        ipersonaService.savePersona(persona);
        return persona;
    }*/
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id,@RequestBody dtoPersona dtoPersona){
        if(!ipersonaService.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoPersona.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es OBLIGATORIO"),HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = ipersonaService.getPersona(id).get();
        persona.setNombre(dtoPersona.getNombre());
        persona.setApellido(dtoPersona.getApellido());
        persona.setImg(dtoPersona.getImg());
        persona.setProfesion(dtoPersona.getProfesion());
        persona.setDescripcion(dtoPersona.getDescripcion());
        persona.setBanner(dtoPersona.getBanner());
        persona.setCv(dtoPersona.getCv());
        
        ipersonaService.savePersona(persona);
        
        return new ResponseEntity(new Mensaje("Persona editada correctamente"),HttpStatus.OK);
    }
    
    /*
    @GetMapping("/traer/perfil")
    public Persona findPersona(){
        return ipersonaService.getPersona((int) 1);
    }*/
    
    @GetMapping("/getPersona/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!ipersonaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona persona = ipersonaService.getPersona(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    
}
