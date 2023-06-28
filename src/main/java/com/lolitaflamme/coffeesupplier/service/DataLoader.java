package com.lolitaflamme.coffeesupplier.service;

import com.lolitaflamme.coffeesupplier.domain.Coffee;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.math.BigDecimal;
import java.util.List;

import static com.lolitaflamme.coffeesupplier.domain.Beans.ARABICA;
import static com.lolitaflamme.coffeesupplier.domain.Beans.ROBUSTA;
import static com.lolitaflamme.coffeesupplier.domain.Roast.DARK_ROAST;
import static com.lolitaflamme.coffeesupplier.domain.Roast.MEDIUM_ROAST;

@Service
@RequiredArgsConstructor
public class DataLoader {

    @NonNull
    CoffeeService coffeeService;

    @PostConstruct
    private void loadData() {
        coffeeService.createCoffees(List.of(
                new Coffee(1L, "Tanzania Gombe", ARABICA, "citrus, walnuts and a hint of honey",
                        MEDIUM_ROAST, new BigDecimal("7.90"), 1.5),
                new Coffee(2L, "Colombia Pink Bourbon", ARABICA, "fruits", MEDIUM_ROAST,
                        new BigDecimal(9.40), 1.5),
                new Coffee(3L, "Espresso India Parchment Robusta", ROBUSTA,
                        "dark chocolate, tobacco and cinnamon", DARK_ROAST, new BigDecimal(6.90), 2.7)));
    }

    @PreDestroy
    private void cleanData(){
        coffeeService.deleteAllCoffees();
    }
}
