package com.conexion.baseDatos.Controller;

import com.conexion.baseDatos.Model.Atencion;
import com.conexion.baseDatos.Service.AtencionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/atencion")
public class AtencionController {

    @Autowired
    private AtencionService atencionService;

    // Crear nueva atención
    @PostMapping
    public ResponseEntity<Atencion> save(@RequestBody Atencion atencion) {
        Atencion saveAtencion = atencionService.save(atencion);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveAtencion);
    }
    // Obtener atención por ID
    @GetMapping("/{id}")
    public ResponseEntity<Atencion> findById(@PathVariable int id) {
        return atencionService.findById(id)
                .map(atencion -> ResponseEntity.ok().body(atencion))
                .orElse(ResponseEntity.notFound().build());
    }
    // Obtener todas las atenciones
    @GetMapping
    public ResponseEntity<Iterable<Atencion>> findAll() {
        return ResponseEntity.ok(atencionService.findAll());
    }

    //Obtiene una atencion entre dos fechas
    @GetMapping("/atenciones/entre-fechas")
    public ResponseEntity<List<Atencion>> obtenerAtencionesEntreFechas(
            @RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam("fin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fin) {

        List<Atencion> atenciones = atencionService.findByEntreDos(inicio, fin);
        return ResponseEntity.ok(atenciones);
    }
    //ahora el de los costos menores
    @GetMapping("/atencion/costo-menor")
    public ResponseEntity<List<Atencion>> findByCostoMenor(@RequestParam double minimo){
        List<Atencion> atencions =atencionService.getFindByCostoMenor(minimo);
        return atencions.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(atencions);
    }
    @GetMapping("/atencion/costo/mayor")
    public ResponseEntity<List<Atencion>> findByCostoMayor(@RequestParam double mayor){
        List<Atencion> atencions =atencionService.findByCostoMayor(mayor);
        return atencions.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(atencions);
    }
}
