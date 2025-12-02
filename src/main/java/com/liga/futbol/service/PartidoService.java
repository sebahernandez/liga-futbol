package com.liga.futbol.service;

import com.liga.futbol.model.entity.Partido;
import com.liga.futbol.model.entity.Liga;
import com.liga.futbol.model.repository.PartidoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Servicio para gestionar operaciones de Partidos
 */
@Service
@Transactional
public class PartidoService {

    private final PartidoRepository partidoRepository;

    public PartidoService(PartidoRepository partidoRepository) {
        this.partidoRepository = partidoRepository;
    }

    /**
     * Obtiene todos los partidos
     */
    public List<Partido> obtenerTodos() {
        return partidoRepository.findAll();
    }

    /**
     * Obtiene un partido por su ID
     */
    public Optional<Partido> obtenerPorId(Integer id) {
        return partidoRepository.findById(id);
    }

    /**
     * Obtiene todos los partidos de una liga
     */
    public List<Partido> obtenerPorLiga(Liga liga) {
        return partidoRepository.findByLiga(liga);
    }

    /**
     * Obtiene partidos de una jornada específica en una liga
     */
    public List<Partido> obtenerPorLigaYJornada(Integer ligaId, Short jornada) {
        return partidoRepository.findByLigaAndJornada(ligaId, jornada);
    }

    /**
     * Obtiene partidos en una fecha específica
     */
    public List<Partido> obtenerPorFecha(LocalDate fecha) {
        return partidoRepository.findByFecha(fecha);
    }

    /**
     * Obtiene partidos en un rango de fechas
     */
    public List<Partido> obtenerEntreFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        return partidoRepository.findByFechaBetween(fechaInicio, fechaFin);
    }

    /**
     * Obtiene todos los partidos de un equipo
     */
    public List<Partido> obtenerPorEquipo(Integer equipoId) {
        return partidoRepository.findByEquipo(equipoId);
    }

    /**
     * Obtiene partidos entre dos equipos específicos
     */
    public List<Partido> obtenerEntreDosEquipos(Integer equipoLocalId, Integer equipoVisitaId) {
        return partidoRepository.findByEquipos(equipoLocalId, equipoVisitaId);
    }

    /**
     * Crea un nuevo partido
     */
    public Partido crear(Partido partido) {
        return partidoRepository.save(partido);
    }

    /**
     * Actualiza un partido existente
     */
    public Optional<Partido> actualizar(Integer id, Partido partidoActualizado) {
        return partidoRepository.findById(id)
            .map(partido -> {
                partido.setJornada(partidoActualizado.getJornada());
                partido.setFecha(partidoActualizado.getFecha());
                partido.setHoraInicio(partidoActualizado.getHoraInicio());
                partido.setEquipoLocal(partidoActualizado.getEquipoLocal());
                partido.setEquipoVisita(partidoActualizado.getEquipoVisita());
                partido.setGolesLocal(partidoActualizado.getGolesLocal());
                partido.setGolesVisita(partidoActualizado.getGolesVisita());
                return partidoRepository.save(partido);
            });
    }

    /**
     * Elimina un partido por su ID
     */
    public boolean eliminar(Integer id) {
        if (partidoRepository.existsById(id)) {
            partidoRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
