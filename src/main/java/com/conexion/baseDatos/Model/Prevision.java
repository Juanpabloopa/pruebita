package com.conexion.baseDatos.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "prevision")
public class Prevision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPrevision;
    @Column(nullable = false,length = 50)
    private String nombre;
    @Column(nullable = false,length = 50)
    private String cobertura;

}
