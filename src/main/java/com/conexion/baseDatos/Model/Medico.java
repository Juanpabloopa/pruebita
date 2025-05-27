package com.conexion.baseDatos.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMedico;

    @Column(unique = true , length = 12)
    private String run;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private Date fechaContrato;

    @Column(nullable = false)
    private int sueldoBase;

    @Column(unique = true, length = 100)
    private String correo;

    @Column(unique = true)
    private String nTelefono;

    @OneToMany(mappedBy = "medico")
    @JsonIgnore
    private List<Atencion> atenciones;

    @ManyToOne
    @JoinColumn(name = "idEspecialidad")  // columna FK en tabla medico
    private Especialidad especialidad;
}
