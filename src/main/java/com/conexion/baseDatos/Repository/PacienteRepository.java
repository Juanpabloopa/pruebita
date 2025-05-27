package com.conexion.baseDatos.Repository;

import com.conexion.baseDatos.Model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    Optional<Paciente> findByRun(String run);

    List<Paciente> findByNombreAndApellido(String nombre, String apellido);

    // Buscar pacientes con menos de 'edad' años
    @Query("SELECT p FROM Paciente p WHERE (CURRENT_DATE - p.fNacimiento) < (:edad * 365)")
    List<Paciente> findByPacienteMenores(@Param("edad") int edad);

    // Buscar pacientes con más de 'edad' años
    @Query("SELECT p FROM Paciente p WHERE (CURRENT_DATE - p.fNacimiento) > (:edad * 365)")
    List<Paciente> findByEdadMayores(@Param("edad") int edad);

}
