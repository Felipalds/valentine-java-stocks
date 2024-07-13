package com.valentinejavastocks.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class StockStatusDTO {
    private String stock;
    private BigDecimal averagePrice;
    private BigDecimal profitAmount;
}
