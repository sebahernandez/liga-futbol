package com.liga.futbol.model.repository;

import com.liga.futbol.model.entity.Liga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio para la entidad Liga
 */
@Repository
public interface LigaRepository extends JpaRepository<Liga, Integer> {

    /**
     * Busca ligas cuyo nombre contenga el texto proporcionado (case-insensitive)
     * @param nombre fragmento del nombre a buscar
     * @return lista de ligas que coinciden
     */
    @Query("SELECT l FROM Liga l WHERE LOWER(l.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    List<Liga> buscarPorNombre(@Param("nombre") String nombre);

    /**
     * Busca ligas por año
     * @param anio año de la liga
     * @return lista de ligas del año especificado
     */
    List<Liga> findByAnio(Short anio);

}
