package com.conexion.baseDatos.Controller;

import com.conexion.baseDatos.Model.Medico;
import com.conexion.baseDatos.Service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/medico")
public class MedicoController {
    @Autowired
    private MedicoService medicoService;
    //LLAMAR AL METODO DE LLAMAR POR EL ID DEL MEDICO
    @GetMapping("/{id}")
    public ResponseEntity<Medico> findById(@PathVariable int id){
        Optional<Medico> medico = medicoService.findById(id);
        return medico.map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }
    //METODO PARA AGREGAR A UN MEDICO
//    @PostMapping
//    public ResponseEntity<Medico> saveMedico(@RequestBody Medico medico){
//        Medico sMedico= medicoService.save(medico);
//        return ResponseEntity.status(HttpStatus.CREATED).body(sMedico);
//    }
    @PostMapping
    public ResponseEntity<?> saveMedico(@RequestBody Medico medico){
        try {
            Medico sMedico = medicoService.save(medico);
            return ResponseEntity.status(HttpStatus.CREATED).body(sMedico);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    //METODO PARA LISTAR A LOS PUTOS MEDICO DEL ORTO
    @GetMapping
    public ResponseEntity<List<Medico>> listMedico(){
        List<Medico> medicos= medicoService.findALL();
        if(medicos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(medicos);
    }
    //EMBOCAR AL MEDICO POR EL RUN
    @GetMapping("/run/{run}")
    public ResponseEntity<Medico> findByRun(@PathVariable String run){
        Optional<Medico> medico = medicoService.findByRun(run);
        return medico.map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }
    //LLAMAR AL METODO DE LAS OTRAS CAPAS DE LLAMAR POR EL NOMBRE Y POR EL APELLDIO
    @GetMapping("/nombre-apellido")
    public ResponseEntity<List<Medico>>  findByNombreApellido(
            @RequestParam String nombre,
            @RequestParam String apellido){
            List<Medico> doctor=  medicoService.findByNombreAndApelldido(nombre, apellido);
            if (doctor.isEmpty()){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(doctor);
    }
    //AHORA LOS QUE TENGAN MENOR ANIOS
    @GetMapping("/medico/menor/{anios}")
    public ResponseEntity<List<Medico>> findByMenorM(@PathVariable int anios){
        return ResponseEntity.ok(medicoService.findByMenosA(anios));
    }
    //AHORA LO QUE TENGAN MAS ANIOS
    @GetMapping("/medico/mayor/{anios}")
    public ResponseEntity<List<Medico>> findByMayorM(@PathVariable int anios){
        return ResponseEntity.ok(medicoService.findByMayorA(anios));
    }

}
