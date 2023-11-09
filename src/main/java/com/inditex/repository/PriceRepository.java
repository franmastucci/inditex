package com.inditex.repository;

import com.inditex.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.Optional;

/**
 * Repositorio JPA para la entidad {@link com.inditex.model.Price}.
 */

public interface PriceRepository extends JpaRepository<Price, Integer> {

    /**
     * Busca y devuelve la entidad {@link com.inditex.model.Price} con la prioridad máxima
     * para una marca, producto y fecha dada.
     *
     * @param brandName El nombre de la marca.
     * @param productId El ID del producto.
     * @param appDate   La fecha de la aplicación.
     * @return Una {@link java.util.Optional} que contiene la entidad {@link com.inditex.model.Price} con la prioridad máxima,
     *         o un contenedor vacío si no se encuentra ninguna entidad que cumpla con los criterios.
     */

    @Query("SELECT p FROM Price p " +
            "JOIN p.brand b " +
            "WHERE b.name = :brandName " +
            "AND p.product.productId = :productId " +
            "AND p.startDate <= :appDate " +
            "AND p.endDate >= :appDate " +
            "AND p.priority = (SELECT MAX(p2.priority) FROM Price p2 " +
                            "WHERE p2.brand.brandId = b.brandId " +
                            "AND p2.product.productId = :productId " +
                            "AND p2.startDate <= :appDate " +
                            "AND p2.endDate >= :appDate)")
    Optional<Price> findMaxPriorityPrice(
            @Param("brandName") String brandName,
            @Param("productId") int productId,
            @Param("appDate") Timestamp appDate
    );

}
