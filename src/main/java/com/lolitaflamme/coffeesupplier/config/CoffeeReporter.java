package com.lolitaflamme.coffeesupplier.config;

import com.lolitaflamme.coffeesupplier.domain.Coffee;
import com.lolitaflamme.coffeesupplier.service.CoffeeService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Supplier;

@Configuration
@AllArgsConstructor
public class CoffeeReporter {

    private final CoffeeService coffeeService;

    @Bean
    Supplier<Iterable<Coffee>> reportAllCoffees() {
        return coffeeService::getCoffees;
    }
}
