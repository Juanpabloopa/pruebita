package com.conexion.baseDatos.Service;

import com.conexion.baseDatos.Model.Paciente;
import com.conexion.baseDatos.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    //MOSTRAR TODOS LOS USUARIOS
    public List<Paciente> findAll(){return pacienteRepository.findAll();}
    //METODO DE AGREGAR
    public Paciente save(Paciente paciente){
        if(paciente.getRun()==null || paciente.getRun().trim().isEmpty()){
            throw  new IllegalArgumentException("El campo de  run no puede estar vacio o nulo");
        }
        //cuando se cumple se podra guardar el run y seguira adelante con el proceso
        return pacienteRepository.save(paciente);
    }
    //METODO PARA LLAMAR POR EL ID
    public Optional<Paciente> findById(int id){return pacienteRepository.findById(id);}
    //BUSCAR AL PACIENTE POR EL RUN
    public Optional<Paciente>  findByRun(String run){return pacienteRepository.findByRun(run); }
    //BUSCAR A UN PACEINTE POR DOS PARAMETROS LOS CUALES SON EL NOMBRE Y EL APELLIDO
    public List<Paciente> findByNombreAndApellido(String nombre,String apellido){return pacienteRepository.findByNombreAndApellido(nombre, apellido);}
    //LOS PACIENTE LOS CUALES TIENEN MENOS EDAD
    public List<Paciente> findByMenores(int edad){return  pacienteRepository.findByPacienteMenores(edad);}
    //AHORA DE LOS QUE TENGAN MAYOR EDAD
    public List<Paciente> findByMayores(int edad){return pacienteRepository.findByEdadMayores(edad);}







}
