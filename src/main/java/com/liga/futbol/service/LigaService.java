package com.liga.futbol.service;

import com.liga.futbol.model.entity.Liga;
import com.liga.futbol.model.repository.LigaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Servicio para gestionar operaciones de Ligas
 */
@Service
@Transactional
public class LigaService {

    private final LigaRepository ligaRepository;

    public LigaService(LigaRepository ligaRepository) {
        this.ligaRepository = ligaRepository;
    }

    /**
     * Obtiene todas las ligas
     */
    public List<Liga> obtenerTodas() {
        return ligaRepository.findAll();
    }

    /**
     * Obtiene una liga por su ID
     */
    public Optional<Liga> obtenerPorId(Integer id) {
        return ligaRepository.findById(id);
    }

    /**
     * Busca ligas por nombre
     */
    public List<Liga> buscarPorNombre(String nombre) {
        return ligaRepository.buscarPorNombre(nombre);
    }

    /**
     * Busca ligas por año
     */
    public List<Liga> buscarPorAnio(Short anio) {
        return ligaRepository.findByAnio(anio);
    }

    /**
     * Crea una nueva liga
     */
    public Liga crear(Liga liga) {
        return ligaRepository.save(liga);
    }

    /**
     * Actualiza una liga existente
     */
    public Optional<Liga> actualizar(Integer id, Liga ligaActualizada) {
        return ligaRepository.findById(id)
            .map(liga -> {
                liga.setNombre(ligaActualizada.getNombre());
                liga.setAnio(ligaActualizada.getAnio());
                liga.setFechaInicio(ligaActualizada.getFechaInicio());
                liga.setFechaFin(ligaActualizada.getFechaFin());
                liga.setDescripcion(ligaActualizada.getDescripcion());
                return ligaRepository.save(liga);
            });
    }

    /**
     * Elimina una liga por su ID
     */
    public boolean eliminar(Integer id) {
        if (ligaRepository.existsById(id)) {
            ligaRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
