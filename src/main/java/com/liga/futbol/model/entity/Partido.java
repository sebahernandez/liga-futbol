package com.liga.futbol.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Entidad que representa un partido de la liga
 */
@Entity
@Table(name = "partidos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "liga_id", nullable = false)
    private Liga liga;

    @Column(nullable = false)
    private Short jornada;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false, name = "hora_inicio")
    private LocalTime horaInicio;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "equipo_local_id", nullable = false)
    private Equipo equipoLocal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "equipo_visita_id", nullable = false)
    private Equipo equipoVisita;

    @Column(name = "goles_local")
    private Short golesLocal;

    @Column(name = "goles_visita")
    private Short golesVisita;

    @Column(length = 20, nullable = false, columnDefinition = "VARCHAR(20) DEFAULT 'PROGRAMADO'")
    private String estado;

    @PrePersist
    public void preInsert() {
        if (this.estado == null) {
            this.estado = "PROGRAMADO";
        }
    }

}
