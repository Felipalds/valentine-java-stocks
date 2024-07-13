package com.valentinejavastocks.Services;

import com.valentinejavastocks.DTOs.GetStatusDTO;
import com.valentinejavastocks.DTOs.StockStatusDTO;
import com.valentinejavastocks.Domains.Customer;
import com.valentinejavastocks.Domains.StockOperation;
import com.valentinejavastocks.Exceptions.CustomerNotFoundException;
import com.valentinejavastocks.Repositories.CustomerRepository;
import com.valentinejavastocks.Repositories.StockOperationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockOperationRepository stockOperationRepository;
    private final CustomerRepository customerRepository;

    public List<StockOperation> getAllStockOperations () {
        return stockOperationRepository.findAll();
    }

    public StockOperation addStockOperation (StockOperation stockOperation) {
        return this.stockOperationRepository.save(stockOperation);
    }

    public List<StockOperation> getStockOperations (Long userId) {
        Customer customer = customerRepository.findById(userId).orElseThrow(CustomerNotFoundException::new);
        return this.stockOperationRepository.findByCustomer(customer);
    }

    public StockStatusDTO getStatus (Long userId, GetStatusDTO getStatusDTO) {
        Customer customer = customerRepository.findById(userId).orElseThrow(CustomerNotFoundException::new);

        List<StockOperation> operations = stockOperationRepository.findByCustomerAndStockAndDateBetween(
                customer,
                getStatusDTO.getStock(),
                getStatusDTO.getStartDate(),
                getStatusDTO.getEndDate()
        );

        AtomicReference<BigDecimal> totalPrice = new AtomicReference<>(BigDecimal.ZERO);
        AtomicReference<Integer> totalStocks = new AtomicReference<>(0);

        operations.forEach(operation -> {
            totalPrice.updateAndGet(v -> v.add(operation.getPrice().multiply(BigDecimal.valueOf(operation.getAmount()))));
            totalStocks.updateAndGet(v -> v + operation.getAmount());
        });
        BigDecimal averagePrice = totalPrice.get().divide(BigDecimal.valueOf(totalStocks.get()), 4);

        return new StockStatusDTO(getStatusDTO.getStock(), averagePrice, BigDecimal.valueOf(0));

    }

}
