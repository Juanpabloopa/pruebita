package com.conexion.baseDatos.Repository;

import com.conexion.baseDatos.Model.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadRepository  extends JpaRepository<Especialidad,Integer> {
}
