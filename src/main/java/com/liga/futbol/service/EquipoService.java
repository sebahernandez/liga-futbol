package com.liga.futbol.service;

import com.liga.futbol.model.entity.Equipo;
import com.liga.futbol.model.repository.EquipoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Servicio para gestionar operaciones de Equipos
 */
@Service
@Transactional
public class EquipoService {

    private final EquipoRepository equipoRepository;

    public EquipoService(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    /**
     * Obtiene todos los equipos
     */
    public List<Equipo> obtenerTodos() {
        return equipoRepository.findAll();
    }

    /**
     * Obtiene un equipo por su ID
     */
    public Optional<Equipo> obtenerPorId(Integer id) {
        return equipoRepository.findById(id);
    }

    /**
     * Busca equipos por nombre (búsqueda parcial, case-insensitive)
     */
    public List<Equipo> buscarPorNombre(String nombre) {
        return equipoRepository.buscarPorNombre(nombre);
    }

    /**
     * Crea un nuevo equipo
     */
    public Equipo crear(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    /**
     * Actualiza un equipo existente
     */
    public Optional<Equipo> actualizar(Integer id, Equipo equipoActualizado) {
        return equipoRepository.findById(id)
            .map(equipo -> {
                equipo.setNombre(equipoActualizado.getNombre());
                equipo.setAnioFundacion(equipoActualizado.getAnioFundacion());
                equipo.setComunaLocal(equipoActualizado.getComunaLocal());
                equipo.setHistoria(equipoActualizado.getHistoria());
                return equipoRepository.save(equipo);
            });
    }

    /**
     * Elimina un equipo por su ID
     */
    public boolean eliminar(Integer id) {
        if (equipoRepository.existsById(id)) {
            equipoRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
