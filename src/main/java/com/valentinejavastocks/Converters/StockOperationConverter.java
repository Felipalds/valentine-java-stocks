package com.valentinejavastocks.Converters;

import com.valentinejavastocks.DTOs.StockOperationDTO;
import com.valentinejavastocks.Domains.StockOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class StockOperationConverter {

    private final CustomerConverter customerConverter;

    public StockOperationDTO toDTO(StockOperation stockOperation) {
        return StockOperationDTO.builder()
                .stock(stockOperation.getStock())
                .amount(stockOperation.getAmount())
                .price(stockOperation.getPrice())
                .customerId(stockOperation.getCustomer().getId())
                .date(stockOperation.getDate())
                .type(stockOperation.getType())
                .build();
    }

    public StockOperation toEntity(StockOperationDTO stockOperationDTO) {
        return StockOperation.builder()
                .stock(stockOperationDTO.getStock())
                .amount(stockOperationDTO.getAmount())
                .price(stockOperationDTO.getPrice())
                .customer(customerConverter.toEntity(stockOperationDTO.getCustomerId()))
                .date(stockOperationDTO.getDate())
                .type(stockOperationDTO.getType())
                .build();
    }
}
