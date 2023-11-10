package com.inditex.integration;

import com.inditex.config.AbstractContainerBaseTest;
import com.inditex.model.dto.PriceResponse;
import com.inditex.repository.PriceRepository;
import com.inditex.service.PriceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;
import java.sql.Timestamp;

import static junit.framework.TestCase.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
@Testcontainers
public class H2IntegrationTest extends AbstractContainerBaseTest {

    @Autowired
    private PriceService priceService;

    @Autowired
    private PriceRepository priceRepository;

    private Long productId;

    private String brand;

    @BeforeEach
    void setup() {
        productId = 35455L;
        brand = "ZARA";
    }

    @Test
    public void get_price_10_on_the_14th_day_test() {
        Timestamp date = Timestamp.valueOf("2020-06-14 10:00:00");
        PriceResponse result = priceService.getPrice(date, productId, brand);
        assertEquals(new BigDecimal("35.50"), result.getFinalPrice());
    }

    @Test
    public void get_price_16_on_the_14th_day_test() {
        Timestamp date = Timestamp.valueOf("2020-06-14 16:00:00");
        PriceResponse result = priceService.getPrice(date, productId, brand);
        assertEquals(new BigDecimal("25.45"), result.getFinalPrice());
    }

    @Test
    public void get_price_21_on_the_14th_day_test() {
        Timestamp date = Timestamp.valueOf("2020-06-14 21:00:00");
        PriceResponse result = priceService.getPrice(date, productId, brand);
        assertEquals(new BigDecimal("35.50"), result.getFinalPrice());
    }

    @Test
    public void get_price_10_on_the_15th_day_test() {
        Timestamp date = Timestamp.valueOf("2020-06-15 10:00:00");
        PriceResponse result = priceService.getPrice(date, productId, brand);
        assertEquals(new BigDecimal("30.50"), result.getFinalPrice());
    }

    @Test
    public void get_price_21_on_the_16th_day_test() {
        Timestamp date = Timestamp.valueOf("2020-06-16 21:00:00");
        PriceResponse result = priceService.getPrice(date, productId, brand);
        assertEquals(new BigDecimal("38.95"), result.getFinalPrice());
    }

}
