package com.conexion.baseDatos.Repository;

import com.conexion.baseDatos.Model.Prevision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrevisionRepository  extends JpaRepository<Prevision,Integer> {
}
