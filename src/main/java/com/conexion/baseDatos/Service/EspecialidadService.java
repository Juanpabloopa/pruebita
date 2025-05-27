package com.conexion.baseDatos.Service;

import com.conexion.baseDatos.Model.Especialidad;
import com.conexion.baseDatos.Repository.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadService {
    @Autowired
    private EspecialidadRepository especialidadRepository;
    //CREAR A UNA NUEVA ESPECIALIDAD
    public Especialidad save(Especialidad especialidad){return especialidadRepository.save(especialidad);  }
    //LLAMAR A TODAS LAS ESPECIALIDADES
    public List<Especialidad> findAll(){
        return especialidadRepository.findAll();
    }



}
