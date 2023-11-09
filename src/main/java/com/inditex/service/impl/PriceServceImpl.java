package com.inditex.service.impl;

import com.inditex.model.Price;
import com.inditex.repository.PriceRepository;
import com.inditex.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.TimeZone;

@Service
public class PriceServceImpl implements PriceService {

    @Autowired
    private PriceRepository priceRepository;

    @Override
    public Price getPrice(Timestamp date, Integer product, String brand) {
        Optional<Price> optionalPrice = priceRepository.findMaxPriorityPrice(brand, product, date);

        return optionalPrice
                .orElseThrow(() -> new RuntimeException("No se encontró el precio para la fecha, producto y marca proporcionados."));
    }

}
