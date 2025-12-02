package com.liga.futbol.controller;

import com.liga.futbol.model.entity.Equipo;
import com.liga.futbol.service.EquipoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gestionar operaciones de Equipos
 */
@RestController
@RequestMapping("/api/equipos")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EquipoController {

    private final EquipoService equipoService;

    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    /**
     * GET /api/equipos
     * Obtiene la lista de todos los equipos
     */
    @GetMapping
    public ResponseEntity<List<Equipo>> obtenerTodos() {
        List<Equipo> equipos = equipoService.obtenerTodos();
        return ResponseEntity.ok(equipos);
    }

    /**
     * GET /api/equipos/{id}
     * Obtiene un equipo específico por su ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Equipo> obtenerPorId(@PathVariable Integer id) {
        Optional<Equipo> equipo = equipoService.obtenerPorId(id);
        return equipo.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * GET /api/equipos/buscar?nombre={texto}
     * Busca equipos por nombre (búsqueda parcial)
     * Ejemplo: GET /api/equipos/buscar?nombre=Colo
     */
    @GetMapping("/buscar")
    public ResponseEntity<List<Equipo>> buscarPorNombre(@RequestParam String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<Equipo> equipos = equipoService.buscarPorNombre(nombre);
        return ResponseEntity.ok(equipos);
    }

    /**
     * POST /api/equipos
     * Crea un nuevo equipo
     * Body ejemplo:
     * {
     *   "nombre": "Colo Colo",
     *   "anioFundacion": 1925,
     *   "comunaLocal": "Santiago",
     *   "historia": "Club de fútbol profesional chileno"
     * }
     */
    @PostMapping
    public ResponseEntity<Equipo> crear(@RequestBody Equipo equipo) {
        try {
            Equipo equipoCreado = equipoService.crear(equipo);
            return ResponseEntity.status(HttpStatus.CREATED).body(equipoCreado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * PUT /api/equipos/{id}
     * Actualiza un equipo existente
     * Body ejemplo:
     * {
     *   "nombre": "Colo Colo Actualizado",
     *   "anioFundacion": 1925,
     *   "comunaLocal": "Santiago",
     *   "historia": "Historia actualizada"
     * }
     */
    @PutMapping("/{id}")
    public ResponseEntity<Equipo> actualizar(
            @PathVariable Integer id,
            @RequestBody Equipo equipoActualizado) {
        Optional<Equipo> equipo = equipoService.actualizar(id, equipoActualizado);
        return equipo.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * DELETE /api/equipos/{id}
     * Elimina un equipo por su ID
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (equipoService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
