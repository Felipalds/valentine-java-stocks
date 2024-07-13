package com.valentinejavastocks.Domains;

import com.valentinejavastocks.Enums.OperationType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "stock_operation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockOperation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "STOCK", nullable = false)
    private String stock;

    @Column(name="PRICE", precision = 16, scale = 2, nullable = false)
    private BigDecimal price;

    @Column(name = "OPERATION_TYPE", nullable = false)
    private OperationType type;

    @Column(name = "AMOUNT", nullable = false)
    private int amount;

    @Column(name = "DATE", nullable = false)
    private Date date;

    @ManyToOne()
    @JoinColumn(name = "USER_ID", nullable = false)
    private Customer customer;

}
