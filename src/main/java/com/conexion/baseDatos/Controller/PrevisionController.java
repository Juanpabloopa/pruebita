package com.conexion.baseDatos.Controller;

import com.conexion.baseDatos.Model.Estado;
import com.conexion.baseDatos.Model.Prevision;
import com.conexion.baseDatos.Service.PrevisionService;
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
@RequestMapping("/api/prevision")
public class PrevisionController {
    @Autowired
    private PrevisionService previsionService;

    //METODO DE AGREGAR
    @PostMapping
    public ResponseEntity<Prevision> save(@RequestBody Prevision prevision){
        Prevision savePrevision1 = previsionService.save(prevision);
        return  ResponseEntity.status(HttpStatus.CREATED).body(savePrevision1);
    }
    @GetMapping
    public  ResponseEntity<List<Prevision>> listPrevision(){
        List<Prevision> previsions = previsionService.findAll();
        if(previsions.isEmpty()){
            return  ResponseEntity.noContent().build();
        }
        return  ResponseEntity.ok(previsions);
    }



}
