package com.valentinejavastocks.Repositories;

import com.valentinejavastocks.Domains.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
