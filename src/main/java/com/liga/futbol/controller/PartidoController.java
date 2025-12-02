package com.liga.futbol.controller;

import com.liga.futbol.model.entity.Partido;
import com.liga.futbol.service.PartidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gestionar operaciones de Partidos
 */
@RestController
@RequestMapping("/api/partidos")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PartidoController {

    private final PartidoService partidoService;

    public PartidoController(PartidoService partidoService) {
        this.partidoService = partidoService;
    }

    /**
     * GET /api/partidos
     * Obtiene la lista de todos los partidos
     */
    @GetMapping
    public ResponseEntity<List<Partido>> obtenerTodos() {
        List<Partido> partidos = partidoService.obtenerTodos();
        return ResponseEntity.ok(partidos);
    }

    /**
     * GET /api/partidos/{id}
     * Obtiene un partido específico por su ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Partido> obtenerPorId(@PathVariable Integer id) {
        Optional<Partido> partido = partidoService.obtenerPorId(id);
        return partido.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * GET /api/partidos/liga/{ligaId}/jornada/{jornada}
     * Obtiene partidos de una jornada específica en una liga
     * Ejemplo: GET /api/partidos/liga/1/jornada/1
     */
    @GetMapping("/liga/{ligaId}/jornada/{jornada}")
    public ResponseEntity<List<Partido>> obtenerPorLigaYJornada(
            @PathVariable Integer ligaId,
            @PathVariable Short jornada) {
        List<Partido> partidos = partidoService.obtenerPorLigaYJornada(ligaId, jornada);
        return ResponseEntity.ok(partidos);
    }

    /**
     * GET /api/partidos/fecha/{fecha}
     * Obtiene partidos en una fecha específica
     * Ejemplo: GET /api/partidos/fecha/2026-01-15
     */
    @GetMapping("/fecha/{fecha}")
    public ResponseEntity<List<Partido>> obtenerPorFecha(@PathVariable LocalDate fecha) {
        List<Partido> partidos = partidoService.obtenerPorFecha(fecha);
        return ResponseEntity.ok(partidos);
    }

    /**
     * GET /api/partidos/rango?fechaInicio={fecha}&fechaFin={fecha}
     * Obtiene partidos en un rango de fechas
     * Ejemplo: GET /api/partidos/rango?fechaInicio=2026-01-01&fechaFin=2026-12-31
     */
    @GetMapping("/rango")
    public ResponseEntity<List<Partido>> obtenerEntreFechas(
            @RequestParam LocalDate fechaInicio,
            @RequestParam LocalDate fechaFin) {
        if (fechaInicio.isAfter(fechaFin)) {
            return ResponseEntity.badRequest().build();
        }
        List<Partido> partidos = partidoService.obtenerEntreFechas(fechaInicio, fechaFin);
        return ResponseEntity.ok(partidos);
    }

    /**
     * GET /api/partidos/equipo/{equipoId}
     * Obtiene todos los partidos de un equipo
     * Ejemplo: GET /api/partidos/equipo/1
     */
    @GetMapping("/equipo/{equipoId}")
    public ResponseEntity<List<Partido>> obtenerPorEquipo(@PathVariable Integer equipoId) {
        List<Partido> partidos = partidoService.obtenerPorEquipo(equipoId);
        return ResponseEntity.ok(partidos);
    }

    /**
     * GET /api/partidos/entre?equipoLocal={id1}&equipoVisita={id2}
     * Obtiene partidos entre dos equipos específicos
     * Ejemplo: GET /api/partidos/entre?equipoLocal=1&equipoVisita=2
     */
    @GetMapping("/entre")
    public ResponseEntity<List<Partido>> obtenerEntreDosEquipos(
            @RequestParam Integer equipoLocal,
            @RequestParam Integer equipoVisita) {
        List<Partido> partidos = partidoService.obtenerEntreDosEquipos(equipoLocal, equipoVisita);
        return ResponseEntity.ok(partidos);
    }

    /**
     * POST /api/partidos
     * Crea un nuevo partido
     * Body ejemplo:
     * {
     *   "liga": {"id": 1},
     *   "jornada": 1,
     *   "fecha": "2026-01-15",
     *   "horaInicio": "15:30:00",
     *   "equipoLocal": {"id": 1},
     *   "equipoVisita": {"id": 2},
     *   "golesLocal": 2,
     *   "golesVisita": 1
     * }
     */
    @PostMapping
    public ResponseEntity<Partido> crear(@RequestBody Partido partido) {
        try {
            Partido partidoCreado = partidoService.crear(partido);
            return ResponseEntity.status(HttpStatus.CREATED).body(partidoCreado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * PUT /api/partidos/{id}
     * Actualiza un partido existente
     */
    @PutMapping("/{id}")
    public ResponseEntity<Partido> actualizar(
            @PathVariable Integer id,
            @RequestBody Partido partidoActualizado) {
        Optional<Partido> partido = partidoService.actualizar(id, partidoActualizado);
        return partido.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * DELETE /api/partidos/{id}
     * Elimina un partido por su ID
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (partidoService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
