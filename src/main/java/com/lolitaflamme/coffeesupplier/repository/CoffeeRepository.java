package com.lolitaflamme.coffeesupplier.repository;

import com.lolitaflamme.coffeesupplier.domain.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository<Coffee, Long> {
}
