package com.liga.futbol.controller;

import com.liga.futbol.model.entity.Liga;
import com.liga.futbol.service.LigaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gestionar operaciones de Ligas
 */
@RestController
@RequestMapping("/api/ligas")
@CrossOrigin(origins = "*", maxAge = 3600)
public class LigaController {

    private final LigaService ligaService;

    public LigaController(LigaService ligaService) {
        this.ligaService = ligaService;
    }

    /**
     * GET /api/ligas
     * Obtiene la lista de todas las ligas
     */
    @GetMapping
    public ResponseEntity<List<Liga>> obtenerTodas() {
        List<Liga> ligas = ligaService.obtenerTodas();
        return ResponseEntity.ok(ligas);
    }

    /**
     * GET /api/ligas/{id}
     * Obtiene una liga específica por su ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Liga> obtenerPorId(@PathVariable Integer id) {
        Optional<Liga> liga = ligaService.obtenerPorId(id);
        return liga.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * GET /api/ligas/buscar?nombre={texto}
     * Busca ligas por nombre (búsqueda parcial)
     * Ejemplo: GET /api/ligas/buscar?nombre=Profesional
     */
    @GetMapping("/buscar")
    public ResponseEntity<List<Liga>> buscarPorNombre(@RequestParam String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<Liga> ligas = ligaService.buscarPorNombre(nombre);
        return ResponseEntity.ok(ligas);
    }

    /**
     * GET /api/ligas/anio/{anio}
     * Busca ligas por año
     * Ejemplo: GET /api/ligas/anio/2026
     */
    @GetMapping("/anio/{anio}")
    public ResponseEntity<List<Liga>> buscarPorAnio(@PathVariable Short anio) {
        List<Liga> ligas = ligaService.buscarPorAnio(anio);
        return ResponseEntity.ok(ligas);
    }

    /**
     * POST /api/ligas
     * Crea una nueva liga
     * Body ejemplo:
     * {
     *   "nombre": "Liga Profesional",
     *   "anio": 2026,
     *   "fechaInicio": "2026-01-01",
     *   "fechaFin": "2026-12-31",
     *   "descripcion": "Liga principal de Chile"
     * }
     */
    @PostMapping
    public ResponseEntity<Liga> crear(@RequestBody Liga liga) {
        try {
            Liga ligaCreada = ligaService.crear(liga);
            return ResponseEntity.status(HttpStatus.CREATED).body(ligaCreada);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * PUT /api/ligas/{id}
     * Actualiza una liga existente
     */
    @PutMapping("/{id}")
    public ResponseEntity<Liga> actualizar(
            @PathVariable Integer id,
            @RequestBody Liga ligaActualizada) {
        Optional<Liga> liga = ligaService.actualizar(id, ligaActualizada);
        return liga.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * DELETE /api/ligas/{id}
     * Elimina una liga por su ID
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (ligaService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
