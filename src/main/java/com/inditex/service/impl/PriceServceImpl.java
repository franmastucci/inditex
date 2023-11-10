package com.inditex.service.impl;

import com.inditex.exception.PriceNotFoundException;
import com.inditex.model.dto.PriceResponse;
import com.inditex.model.entity.Price;
import com.inditex.repository.PriceRepository;
import com.inditex.service.PriceService;
import com.inditex.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class PriceServceImpl implements PriceService {

    @Autowired
    private PriceRepository priceRepository;

    @Override
    public PriceResponse getPrice(Timestamp date, Long product, String brand) {

        Price price =  priceRepository.findMaxPriorityPrice(brand, product, date)
                .orElseThrow(() -> new PriceNotFoundException(Constants.NULL_PRICE_EXCEPTION_MSG));

        return PriceResponse.priceToPriceResponse(price,date);

    }

}
