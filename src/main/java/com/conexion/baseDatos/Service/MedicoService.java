package com.conexion.baseDatos.Service;

import com.conexion.baseDatos.Model.Medico;
import com.conexion.baseDatos.Repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;
    //METODO QUE AGREGA A UN MEDICO
    //public Medico save (Medico medico){return medicoRepository.save(medico);}
    public Medico save(Medico medico) {
        if (medico.getRun() == null || medico.getRun().trim().isEmpty()) {
            throw new IllegalArgumentException("El campo 'run' no puede estar vacío o nulo.");
        }
        // Otras validaciones que quieras agregar...
        return medicoRepository.save(medico);
    }
    //METODO PARA BUSCAR A UN MEDICO POR SU ID
    public Optional<Medico> findById(int id){return medicoRepository.findById(id);}
    //METODO PARA LISTAR A LOS MEDICO
    public List<Medico> findALL(){return medicoRepository.findAll();}
    //METODO PARA ELIMINAR A LOS MEDICO
    public void deleteById(int id){medicoRepository.deleteById(id);}
    //BUSCAR AL MEDICO POR EL NOMBRE Y EL APELLIDO
    public List<Medico> findByNombreAndApelldido(String nombre, String apellido){return medicoRepository.findByNombreAndApellido(nombre,apellido);}
    //LLAMAR POR EL PUTO RUN AL MEDIQUITO
    public Optional<Medico> findByRun(String run){return medicoRepository.findByRun(run);}
    //AHORA DEBEMOS LLAMAR A LOS MEDICO LOS CUALES TENGAN MENOS ANIOS DE ANTIGUEDAD
    public List<Medico> findByMenosA(int anios){
        return medicoRepository.findByMenorC(anios);
    }
    //AHORA LOS CUALES TENGAN MAYOR ANIOS DE ANTIGUEDAD
    public List<Medico> findByMayorA(int anios){
        return medicoRepository.findByMasC(anios);
    }
}
