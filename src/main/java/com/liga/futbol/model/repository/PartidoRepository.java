package com.liga.futbol.model.repository;

import com.liga.futbol.model.entity.Partido;
import com.liga.futbol.model.entity.Liga;
import com.liga.futbol.model.entity.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Repositorio para la entidad Partido
 */
@Repository
public interface PartidoRepository extends JpaRepository<Partido, Integer> {

    /**
     * Busca partidos por liga
     * @param liga la liga especificada
     * @return lista de partidos de la liga
     */
    List<Partido> findByLiga(Liga liga);

    /**
     * Busca partidos por jornada en una liga específica
     * @param ligaId ID de la liga
     * @param jornada número de la jornada
     * @return lista de partidos de esa jornada
     */
    @Query("SELECT p FROM Partido p WHERE p.liga.id = :ligaId AND p.jornada = :jornada")
    List<Partido> findByLigaAndJornada(@Param("ligaId") Integer ligaId, @Param("jornada") Short jornada);

    /**
     * Busca partidos por fecha
     * @param fecha fecha del partido
     * @return lista de partidos en esa fecha
     */
    List<Partido> findByFecha(LocalDate fecha);

    /**
     * Busca partidos entre dos fechas
     * @param fechaInicio fecha inicial
     * @param fechaFin fecha final
     * @return lista de partidos en ese rango
     */
    @Query("SELECT p FROM Partido p WHERE p.fecha BETWEEN :fechaInicio AND :fechaFin ORDER BY p.fecha, p.horaInicio")
    List<Partido> findByFechaBetween(@Param("fechaInicio") LocalDate fechaInicio, @Param("fechaFin") LocalDate fechaFin);

    /**
     * Busca partidos donde juega un equipo específico
     * @param equipoId ID del equipo
     * @return lista de partidos donde participa ese equipo
     */
    @Query("SELECT p FROM Partido p WHERE p.equipoLocal.id = :equipoId OR p.equipoVisita.id = :equipoId")
    List<Partido> findByEquipo(@Param("equipoId") Integer equipoId);

    /**
     * Busca partidos entre dos equipos específicos
     * @param equipoLocalId ID del equipo local
     * @param equipoVisitaId ID del equipo visitante
     * @return lista de partidos entre esos equipos
     */
    @Query("SELECT p FROM Partido p WHERE (p.equipoLocal.id = :equipoLocalId AND p.equipoVisita.id = :equipoVisitaId) OR (p.equipoLocal.id = :equipoVisitaId AND p.equipoVisita.id = :equipoLocalId)")
    List<Partido> findByEquipos(@Param("equipoLocalId") Integer equipoLocalId, @Param("equipoVisitaId") Integer equipoVisitaId);

}
