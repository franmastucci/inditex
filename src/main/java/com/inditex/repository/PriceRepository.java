package com.inditex.repository;

import com.inditex.model.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.Optional;

/**
 * JPA repository for the {@link Price} entity.
 */
public interface PriceRepository extends JpaRepository<Price, Integer> {

    /**
     * Searches and returns the {@link Price} entity with the highest priority
     * for a given brand, product, and date.
     *
     * @param brandName The name of the brand.
     * @param productId The ID of the product.
     * @param appDate   The application date.
     * @return An {@link Optional} containing the {@link Price} entity with the highest priority,
     *         or an empty container if no entity is found that meets the criteria.
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
            @Param("productId") Long productId,
            @Param("appDate") Timestamp appDate
    );

}
