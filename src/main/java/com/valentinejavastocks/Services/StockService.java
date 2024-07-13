package com.valentinejavastocks.Services;

import com.valentinejavastocks.Domains.Customer;
import com.valentinejavastocks.Domains.StockOperation;
import com.valentinejavastocks.Exceptions.CustomerNotFoundException;
import com.valentinejavastocks.Repositories.CustomerRepository;
import com.valentinejavastocks.Repositories.StockOperationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockOperationRepository stockOperationRepository;
    private final CustomerRepository customerRepository;

    public List<StockOperation> getAllStockOperations () {
        return this.stockOperationRepository.findAll();
    }

    public StockOperation addStockOperation (StockOperation stockOperation) {
        return this.stockOperationRepository.save(stockOperation);
    }

    public List<StockOperation> getStockOperations (Long userId) {
        Customer customer = customerRepository.findById(userId).orElseThrow(CustomerNotFoundException::new);
        return this.stockOperationRepository.findByCustomer(customer);
    }
}
