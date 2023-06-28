package com.lolitaflamme.coffeesupplier.service;

import com.lolitaflamme.coffeesupplier.domain.Coffee;
import com.lolitaflamme.coffeesupplier.repository.CoffeeRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CoffeeService {

    @NonNull
    private final CoffeeRepository coffeeRepository;

    public Iterable<Coffee> getCoffees() {
        return coffeeRepository.findAll();
    }

    public Iterable<Coffee> createCoffees(Iterable<Coffee> coffees) {
        return coffeeRepository.saveAll(coffees);
    }

    public Coffee createCoffee(Coffee coffee) {
        return coffeeRepository.save(coffee);
    }

    public Optional<Coffee> getCoffeeById(Long id) {
        return coffeeRepository.findById(id);
    }

    public Coffee updateCoffee(Coffee coffee) {
        return coffeeRepository.save(coffee);
    }

    public void deleteCoffeeById(Long id) {
        coffeeRepository.deleteById(id);
    }

    public boolean coffeeExistsById(Long id) {
        return coffeeRepository.existsById(id);
    }

    public void deleteAllCoffees() {
        coffeeRepository.deleteAll();
    }
}
