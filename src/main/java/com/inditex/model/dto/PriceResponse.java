package com.inditex.model.dto;


import com.inditex.model.entity.Brand;
import com.inditex.model.entity.Currency;
import com.inditex.model.entity.Price;
import com.inditex.model.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PriceResponse {

    private Long brandId;

    private String brandName;

    private Long pruductId;

    private String productName;

    private Long priceId;

    private Timestamp appDate;

    private BigDecimal finalPrice;


    public static PriceResponse priceToPriceResponse(Price price, Timestamp date) {
        return PriceResponse.builder()
                .brandId(price.getBrand().getBrandId())
                .brandName(price.getBrand().getName())
                .pruductId(price.getProduct().getProductId())
                .productName(price.getProduct().getName())
                .priceId(price.getPriceId())
                .appDate(date)
                .finalPrice(price.getPriceValue())
                .build();
    }

}
