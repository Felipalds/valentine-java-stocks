package com.valentinejavastocks.Converters;

import com.valentinejavastocks.DTOs.StockOperationDTO;
import com.valentinejavastocks.Domains.StockOperation;

public class StockOperationConverter {
    public static StockOperationDTO toDTO(StockOperation stockOperation) {
        return StockOperationDTO.builder()
                .stock(stockOperation.getStock())
                .amount(stockOperation.getAmount())
                .price(stockOperation.getPrice())
                .user(CustomerConverter.toDTO(stockOperation.getCustomer()))
                .build();
    }

    public static StockOperation toEntity(StockOperationDTO stockOperationDTO) {
        return StockOperation.builder()
                .stock(stockOperationDTO.getStock())
                .amount(stockOperationDTO.getAmount())
                .price(stockOperationDTO.getPrice())
                .customer(CustomerConverter.toEntity(stockOperationDTO.getUser()))
                .build();
    }
}
