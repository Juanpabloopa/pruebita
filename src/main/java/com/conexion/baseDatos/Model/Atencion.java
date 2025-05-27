package com.conexion.baseDatos.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "atenciones")
public class Atencion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAtencion;
    @Column(nullable = true)
    private LocalDate fechaAtencion;
    @Column(nullable = true)
    private LocalTime horaAtencion;
    @Column( nullable = false)
    private Double costo;
    @Column(length = 500)
    private String comentarios;
    //CONEXIONES
    @ManyToOne
    @JoinColumn(name = "idMedico")
    private Medico medico;
    @ManyToOne
    @JoinColumn(name = "idPaciente")
    private Paciente paciente;
    @ManyToOne
    @JoinColumn(name = "idEstado")
    @JsonIgnore
    private Estado estado;
}
