package com.valentinejavastocks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.valentinejavastocks.*"})
@EnableJpaRepositories("com.valentinejavastocks.*")
@EntityScan("com.valentinejavastocks.*")
public class ValentineJavaStocksApplication {

    public static void main(String[] args) {
        SpringApplication.run(ValentineJavaStocksApplication.class, args);
    }

}
