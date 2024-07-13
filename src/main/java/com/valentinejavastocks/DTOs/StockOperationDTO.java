package com.valentinejavastocks.DTOs;

import com.valentinejavastocks.Enums.OperationType;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class StockOperationDTO implements Serializable {
    private Long customerId;
    private String stock;
    private int amount;
    private BigDecimal price;
    private OperationType type;
    private Date date;
}
