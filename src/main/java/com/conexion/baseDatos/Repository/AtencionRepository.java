package com.conexion.baseDatos.Repository;

import com.conexion.baseDatos.Model.Atencion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AtencionRepository extends JpaRepository<Atencion, Integer> {

    // Buscar todas las atenciones según su fecha de atención
    @Query("SELECT a FROM Atencion a WHERE a.fechaAtencion = :fecha")
    List<Atencion> findByFecha(@Param("fecha") LocalDate fecha);

    // Buscar atenciones entre dos fechas
    @Query("SELECT a FROM Atencion a WHERE a.fechaAtencion BETWEEN :inicio AND :fin")
    List<Atencion> findByAtencionesEntreFechas(@Param("inicio") LocalDate inicio, @Param("fin") LocalDate fin);

    // Atenciones con costo menor a cierto valor
    @Query("SELECT a FROM Atencion a WHERE a.costo < :costominimo")
    List<Atencion> findByCostoMenor(@Param("costominimo") double costominimo);

    // Atenciones con costo mayor a cierto valor
    @Query("SELECT a FROM Atencion a WHERE a.costo > :costomaximo")
    List<Atencion> findByCostoMayor(@Param("costomaximo") double costomaximo);
}
