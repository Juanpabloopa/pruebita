package com.conexion.baseDatos.Service;

import com.conexion.baseDatos.Model.Estado;
import com.conexion.baseDatos.Repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {
    @Autowired
    private EstadoRepository estadoRepository;

    /// llamar a todos los estados
    public List<Estado> findAll(){return estadoRepository.findAll();}
    //AGREGAR NUEVOS ESTADOS
    public Estado save (Estado estado){return estadoRepository.save(estado);}
    //eliminar un estado
    public  void deleteById(int id){
        estadoRepository.deleteById(id);
    }
    //buscar ESTADO POR EL UD
    public Optional<Estado> findById(int id){
        return estadoRepository.findById(id);
    }





}
