package com.inditex.controller;

import com.inditex.model.Price;
import com.inditex.service.PriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@Slf4j
public class PriceController {

    @Autowired
    private PriceService priceService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Price getPrice(@RequestParam("date") Timestamp date, @RequestParam("product") Integer product, @RequestParam("brand") String brand ) {

        log.info("controller trace: " + "date= " + date + ", product=" + product + ", brand=" + brand);

        return priceService.getPrice(date,product,brand);
    }

}
