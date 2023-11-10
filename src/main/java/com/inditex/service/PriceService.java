package com.inditex.service;

import com.inditex.model.dto.PriceResponse;

import java.sql.Timestamp;

public interface PriceService {
    PriceResponse getPrice(Timestamp date, Long product, String brand);
}
