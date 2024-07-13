package com.valentinejavastocks.DTOs;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
public class StockOperationDTO implements Serializable {
    private Long id;
    private CustomerDTO user;
    private String stock;
    private int amount;
    private BigDecimal price;
    private String operationType;
}
