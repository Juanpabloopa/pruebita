package com.conexion.baseDatos.Controller;

import com.conexion.baseDatos.Model.Estado;
import com.conexion.baseDatos.Model.Medico;
import com.conexion.baseDatos.Model.Paciente;
import com.conexion.baseDatos.Service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/paciente")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    //METODO DE AGREGAR UN PACIENTE
    @PostMapping
    public ResponseEntity<Paciente> savePaciente(@RequestBody Paciente paciente){
        Paciente savePaciente1 = pacienteService.save(paciente);
        return  ResponseEntity.status(HttpStatus.CREATED).body(savePaciente1);
    }
    //METODO PARA MOSTRAR TODOS LOS PACIENTES 👍
    @GetMapping
    public ResponseEntity<List<Paciente>> list() {
        List<Paciente> pacientes = pacienteService.findAll();
        if (pacientes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pacientes);
    }
    //LLAMAR AL CLIENTE SOLO POR EL ID 👍
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> findById(@PathVariable int id){
        Optional<Paciente> paciente= pacienteService.findById(id);
        return paciente.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    //LLAMAR AL PACIENTE SOLO POR  EL RUN 👍
    @GetMapping("/run/{run}")
    public ResponseEntity<Paciente> findByRun(@PathVariable String run){
        Optional<Paciente> paciente = pacienteService.findByRun(run);
        return paciente.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    //LLAMAR A LOS PACIENTES QUE SEAN MENORES
    @GetMapping("/paciente/menor/{edad}")
    public  ResponseEntity<List<Paciente>> findByMenores( @PathVariable int edad){
        return  ResponseEntity.ok(pacienteService.findByMenores(edad));
    }
    //AHORA ES DE LLAMAR A LOS MAYORES N
    @GetMapping("/paciente/mayor/{edad}")
    public ResponseEntity<List<Paciente>> findByMayores (@PathVariable int edad){
        return ResponseEntity.ok(pacienteService.findByMayores(edad));
    }

}
