package com.conexion.baseDatos.Service;

import com.conexion.baseDatos.Model.Estado;
import com.conexion.baseDatos.Model.Prevision;
import com.conexion.baseDatos.Repository.PrevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrevisionService {
    @Autowired
    private PrevisionRepository previsionRepository;
    //METODO DE AGREGAR UNA PREVISION
    public Prevision save (Prevision prevision){return previsionRepository.save(prevision);}
    //LISTA la cual retorna todas las prevenciones
    public List<Prevision> findAll(){return previsionRepository.findAll(); }
    //ELIMINAR UNA PREVISION
    public void deleteById(int id){
        previsionRepository.deleteById(id);
    }
}
