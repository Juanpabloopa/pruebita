package com.conexion.baseDatos.Controller;

import com.conexion.baseDatos.Model.Estado;
import com.conexion.baseDatos.Service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/estado")
public class EstadoController {
    @Autowired
    private EstadoService estadoService;

    //Buscar estado por el id
    @GetMapping("/{id}")
    public ResponseEntity<Estado> findByid (@PathVariable int id){
        Optional<Estado> estado = estadoService.findById(id);
        return estado.map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    //LISTAR LOS ESTADOS
    @GetMapping
    public ResponseEntity<List<Estado>> list(){
        List<Estado> estados = estadoService.findAll();
        if(estados.isEmpty()){
            return  ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(estados);
    }
    //METODO PARA AGREGAR UN ESTADO
    @PostMapping
    public ResponseEntity<Estado> save(@RequestBody Estado estado){
        Estado saveEstado = estadoService.save(estado);
        return  ResponseEntity.status(HttpStatus.CREATED).body(saveEstado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id){
        estadoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }







}
