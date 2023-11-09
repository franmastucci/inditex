package com.inditex.service;

import com.inditex.model.Price;


import java.sql.Timestamp;

public interface PriceService {
    Price getPrice(Timestamp date, Integer product, String brand);
}
