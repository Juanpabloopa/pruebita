package com.conexion.baseDatos.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Table(name = "paciente")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Paciente {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idPaciente;
    @Column(unique = false ,length = 12)
    private  String run;
    @Column(nullable = false,length = 50)
    private String nombre;
    @Column(nullable = false,length = 50)
    private String apellido;
    @Column(nullable = true )
    private Date fNacimiento;
    @Column(unique = false ,length =200 )
    private  String correo;
    @Column(unique = false,length = 20)
    private String numero;
     //CLAVE FORANEA QUE RECIBE
    @ManyToOne
    @JoinColumn(name = "idPrevision")
    private Prevision prevision;

    @OneToMany(mappedBy = "paciente")
    @JsonIgnore
    private List<Atencion> atencions ;



}
