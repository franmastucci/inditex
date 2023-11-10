package com.inditex.controller;

import com.inditex.config.AbstractContainerBaseTest;
import com.inditex.repository.PriceRepository;
import com.inditex.service.PriceService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.junit.jupiter.Testcontainers;


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Testcontainers
public class PriceControllerTest extends AbstractContainerBaseTest {

    @Autowired
    private PriceService priceService;

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private MockMvc mockMvc;

    private Long productId;

    private String brand;

    private final String PRICES_PATH = "/prices";

    @BeforeEach
    void setup() {
        productId = 35455L;
        brand = "ZARA";
    }

    @Test
    public void get_price_10_on_the_14th_day_test() throws Exception {
        String date = "2020-06-14 10:00:00";
        mockMvc.perform(MockMvcRequestBuilders.get(PRICES_PATH)
                        .param("date", date)
                        .param("product", String.valueOf(productId))
                        .param("brand", brand))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.finalPrice",
                        Matchers.closeTo(35.50, 0.01)));
    }

    @Test
    public void get_price_16_on_the_14th_day_test() throws Exception {
        String date = "2020-06-14 16:00:00";
        mockMvc.perform(MockMvcRequestBuilders.get(PRICES_PATH)
                        .param("date", date)
                        .param("product", String.valueOf(productId))
                        .param("brand", brand))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.finalPrice",
                        Matchers.closeTo(25.45, 0.01)));
    }

    @Test
    public void get_price_21_on_the_14th_day_test() throws Exception {
        String date = "2020-06-14 21:00:00";
        mockMvc.perform(MockMvcRequestBuilders.get(PRICES_PATH)
                        .param("date", date)
                        .param("product", String.valueOf(productId))
                        .param("brand", brand))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.finalPrice",
                        Matchers.closeTo(35.50, 0.01)));
    }

    @Test
    public void get_price_10_on_the_15th_day_test() throws Exception {
        String date = "2020-06-15 10:00:00";
        mockMvc.perform(MockMvcRequestBuilders.get(PRICES_PATH)
                        .param("date", date)
                        .param("product", String.valueOf(productId))
                        .param("brand", brand))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.finalPrice",
                        Matchers.closeTo(30.50, 0.01)));
    }

    @Test
    public void get_price_21_on_the_16th_day_test() throws Exception {
        String date = "2020-06-16 21:00:00";
        mockMvc.perform(MockMvcRequestBuilders.get(PRICES_PATH)
                        .param("date", date)
                        .param("product", String.valueOf(productId))
                        .param("brand", brand))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.finalPrice",
                        Matchers.closeTo(38.95, 0.01)));
    }

}
