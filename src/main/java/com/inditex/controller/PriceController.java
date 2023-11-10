package com.inditex.controller;

import com.inditex.model.dto.PriceResponse;
import com.inditex.service.PriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

/**
 * Controller class for handling price-related endpoints.
 */
@RestController
@RequestMapping("/prices")
@Slf4j
public class PriceController {

    @Autowired
    private PriceService priceService;

    /**
     * Retrieves the price for the given date, product, and brand.
     *
     * @param date   The date for which the price is requested.
     * @param product The ID of the product.
     * @param brand   The name of the brand.
     * @return A ResponseEntity containing the PriceResponse, with HTTP status OK if successful.
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PriceResponse> getPrice(@RequestParam("date") Timestamp date, @RequestParam("product") Long product,
                                                  @RequestParam("brand") String brand ) {

        log.debug("Controller trace: " + "date= " + date + ", product=" + product + ", brand=" + brand);
        return ResponseEntity.ok().body(priceService.getPrice(date,product,brand));
    }

}
