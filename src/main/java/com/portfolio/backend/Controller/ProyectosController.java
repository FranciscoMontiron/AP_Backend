
package com.portfolio.backend.Controller;

import com.portfolio.backend.Dto.DtoProyectos;
import com.portfolio.backend.Entity.Proyecto;
import com.portfolio.backend.Security.Controller.Mensaje;
import com.portfolio.backend.Service.ProyectoService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proyecto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProyectosController {
    
    @Autowired 
    private ProyectoService proyectServ;
    
    @GetMapping("/list")
    public ResponseEntity<List<Proyecto>> listProyects(){
        List<Proyecto> listProyects = proyectServ.getListProyectos();
        return new ResponseEntity(listProyects,HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProyectos dtoProyecto){
        if(StringUtils.isBlank(dtoProyecto.getNombreP())){
            return new ResponseEntity(new Mensaje("Titulo del proyecto es OBLIGATORIO"),HttpStatus.BAD_REQUEST);
        }
        if(proyectServ.existsByNombreP(dtoProyecto.getNombreP())){
            return new ResponseEntity(new Mensaje("Ese nombre del proyecto ya existe"),HttpStatus.BAD_REQUEST);
        }
        Proyecto proyecto = new Proyecto(dtoProyecto.getNombreP(),dtoProyecto.getUrlP(),dtoProyecto.getDescripcionP(),dtoProyecto.getImgP(),dtoProyecto.getFecha());
        proyectServ.saveProyecto(proyecto);
        
        return new ResponseEntity(new Mensaje("Proyecto creado con exito"),HttpStatus.OK);
    }
    
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id,@RequestBody DtoProyectos dtoProyecto){
        if(!proyectServ.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"),HttpStatus.BAD_REQUEST);
        }
        if(proyectServ.existsByNombreP(dtoProyecto.getNombreP()) && proyectServ.getByNombreP(dtoProyecto.getNombreP()).get().getId()!= id){
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoProyecto.getNombreP())){
            return new ResponseEntity(new Mensaje("El titulo es OBLIGATORIO"),HttpStatus.BAD_REQUEST);
        }
        
        Proyecto proyecto = proyectServ.getProyecto(id).get();
        proyecto.setNombreP(dtoProyecto.getNombreP());
        proyecto.setUrlP(dtoProyecto.getUrlP());
        proyecto.setDescripcionP(dtoProyecto.getDescripcionP());
        proyecto.setImgP(dtoProyecto.getImgP());
        proyecto.setFecha(dtoProyecto.getFecha());
        
        proyectServ.saveProyecto(proyecto);
        
        return new ResponseEntity(new Mensaje("Proyecto editado correctamente"),HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!proyectServ.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"),HttpStatus.BAD_REQUEST);
        }
        proyectServ.deleteProyecto(id);
        
        return new ResponseEntity(new Mensaje("Proyecto eliminado correctamente"),HttpStatus.OK);
    }
    
    @GetMapping("/getProyecto/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id){
        if(!proyectServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyecto proyecto = proyectServ.getProyecto(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
}
