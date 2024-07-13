package com.valentinejavastocks.Domains;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "customer", uniqueConstraints = { @UniqueConstraint(columnNames = "email")})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;
}
