package com.conexion.baseDatos.Repository;

import com.conexion.baseDatos.Model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {

    // Buscar al MEDICO POR EL RUN
    Optional<Medico> findByRun(String run);

    // Buscar por nombre y apellido
    List<Medico> findByNombreAndApellido(String nombre, String apellido);

    // Médicos con MENOS de X años de antigüedad (en Oracle, 1 año ≈ 365 días)
    @Query("SELECT m FROM Medico m WHERE (CURRENT_DATE - m.fechaContrato) < (:anios * 365)")
    List<Medico> findByMenorC(@Param("anios") int anios);

    // Médicos con MÁS de X años de antigüedad
    @Query("SELECT m FROM Medico m WHERE (CURRENT_DATE - m.fechaContrato) > (:anios * 365)")
    List<Medico> findByMasC(@Param("anios") int anios);
}
