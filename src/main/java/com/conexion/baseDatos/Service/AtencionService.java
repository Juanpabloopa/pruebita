package com.conexion.baseDatos.Service;

import com.conexion.baseDatos.Model.Atencion;
import com.conexion.baseDatos.Model.Medico;
import com.conexion.baseDatos.Repository.AtencionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AtencionService {

    @Autowired
    private AtencionRepository atencionRepository;

    // Guardar una atención
    public Atencion save(Atencion atencion) {
        return atencionRepository.save(atencion);
    }
    // Buscar atención por ID
    public Optional<Atencion> findById(int id) {
        return atencionRepository.findById(id);
    }
    //LLAMAR A TODAS LAS ATENCIONES
    public List<Atencion> findAll() {
        return atencionRepository.findAll();
    }
    //BUSCAR A ATENCIONES POR ENTRE DOS FECHAS
    public List<Atencion> findByEntreDos(LocalDate inicio,LocalDate fin){
        return atencionRepository.findByAtencionesEntreFechas(inicio,fin);
    }
    //ATENCIONES CON EL COSTO BAJITO
    public List<Atencion> getFindByCostoMenor(double costoMinimo){
        return atencionRepository.findByCostoMenor(costoMinimo);
    }
    //AHORA CON LOS DEL COSTO MAYOR
    public List<Atencion> findByCostoMayor(double costoMaximo){
        return atencionRepository.findByCostoMayor(costoMaximo);
    }
}




