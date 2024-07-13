package com.valentinejavastocks.Repositories;

import com.valentinejavastocks.Domains.Customer;
import com.valentinejavastocks.Domains.StockOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockOperationRepository extends JpaRepository<StockOperation, Long> {

    public List<StockOperation> findByCustomer (Customer customer);
}
