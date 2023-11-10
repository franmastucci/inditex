package com.inditex.service;

import com.inditex.model.dto.PriceResponse;
import com.inditex.model.entity.Price;


import java.sql.Timestamp;

public interface PriceService {
    PriceResponse getPrice(Timestamp date, Long product, String brand);
}
