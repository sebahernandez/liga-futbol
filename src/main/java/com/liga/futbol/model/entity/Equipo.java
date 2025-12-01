package com.liga.futbol.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad que representa un equipo participante en la liga
 */
@Entity
@Table(name = "equipos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 100)
    private String nombre;

    @Column(nullable = false, name = "anio_fundacion")
    private Short anioFundacion;

    @Column(nullable = false, length = 80, name = "comuna_local")
    private String comunaLocal;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String historia;

}
