package com.liga.futbol.model.repository;

import com.liga.futbol.model.entity.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio para la entidad Equipo
 */
@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Integer> {

    /**
     * Busca equipos cuyo nombre contenga el texto proporcionado (case-insensitive)
     * @param nombre fragmento del nombre a buscar
     * @return lista de equipos que coinciden
     */
    @Query("SELECT e FROM Equipo e WHERE LOWER(e.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    List<Equipo> buscarPorNombre(@Param("nombre") String nombre);

}
