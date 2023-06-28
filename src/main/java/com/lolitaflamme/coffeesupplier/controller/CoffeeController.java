package com.lolitaflamme.coffeesupplier.controller;

import com.lolitaflamme.coffeesupplier.domain.Coffee;
import com.lolitaflamme.coffeesupplier.service.CoffeeService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/coffees")
public class CoffeeController {

    @NonNull
    private final CoffeeService coffeeService;

    @GetMapping
    public Iterable<Coffee> getCoffees() {
        return coffeeService.getCoffees();
    }

    @PostMapping
    public ResponseEntity<Coffee> createCoffee(@RequestBody Coffee coffee) {
        return new ResponseEntity<>(coffeeService.createCoffee(coffee), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coffee> getCoffeeById(@PathVariable Long id) {
        Optional<Coffee> coffee = coffeeService.getCoffeeById(id);
        return coffee.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coffee> updateCoffee(@PathVariable Long id,
                                               @RequestBody Coffee coffee) {
        return coffeeService.coffeeExistsById(id)
                ? new ResponseEntity<>(coffeeService.updateCoffee(coffee), HttpStatus.OK)
                : new ResponseEntity<>(coffeeService.createCoffee(coffee), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Coffee> deleteCoffee(@PathVariable Long id) {
        coffeeService.deleteCoffeeById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
