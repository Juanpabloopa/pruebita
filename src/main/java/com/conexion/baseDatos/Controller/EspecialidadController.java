package com.conexion.baseDatos.Controller;

import com.conexion.baseDatos.Model.Especialidad;
import com.conexion.baseDatos.Service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/especialidad")
public class EspecialidadController {
    @Autowired
    private EspecialidadService especialidadService;

    @PostMapping
    public ResponseEntity<Especialidad> saveEspecialidad(@RequestBody Especialidad especialidad) {
        Especialidad sEspecialidad = especialidadService.save(especialidad);
        return ResponseEntity.status(HttpStatus.CREATED).body(sEspecialidad);
    }
    //METODO PARA LLAMAR A TODAS LAS ESPECIALIDADES
    @GetMapping
    public ResponseEntity<List<Especialidad>> list(){
        List<Especialidad> especialidads = especialidadService.findAll();
        if(especialidads.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(especialidads);
    }


}